/*
*
*
* Copyright (C) 2011-2012 Jorge Luis Martinez Ramirez
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*
* Author: Jorge Luis Martinez Ramirez
* Email: jorgemfk1@gmail.com
*/
package mx.dr.util.report.impl;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import mx.dr.util.report.IPdfService;
import mx.dr.util.report.tag.DRPdfColumn;
import mx.dr.util.report.tag.DRPdfDocument;
import mx.dr.util.report.tag.DRPdfImage;
import mx.dr.util.report.tag.DRPdfLabel;
import mx.dr.util.report.tag.DRPdfObject;
import mx.dr.util.report.tag.DRPdfTable;

/**
 *
 * <br/>
 * Implementacion del servicio pdf.
 * @author Jorge Luis Martinez Ramirez
 * @version 0.9
 * @since 13/08/2011
 * @since 0.9v
 */
public class PdfService implements IPdfService{
    /**
	* formato por defecto de los valores numericos.
	*/
	public static final DecimalFormat def = new DecimalFormat( "#,###,###.00");
	/**
	* formato de fecha por defecto.
	*/
	private final SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
	/**
	* directorio donde se almacenan las fuentes.
	*/
	private static final String TTFDIR= PdfService.class.getResource( "/drreports.properties").getPath().replaceFirst("/drreports.properties", "") + "/../../TTF" ;//+ ("parametro.pdf.font");
	/**
	* directorio donde se guardan las imagenes.
	*/
	private static final String IMGDIR= PdfService.class.getResource( "/drreports.properties").getPath().replaceFirst("/drreports.properties", "") + "/../../IMG"; //+ ("parametro.pdf.image");

    /**
    * @see mx.dr.util.report.IPdfService#genMultiPagesPDF(java.util.List)
	*/
	public String genMultiPagesPDF(List<DRPdfObject> lista) throws Exception{
		DRPdfDocument anonDoc=null;
		String file=null;
		for(DRPdfObject o:lista){
			anonDoc = o.getClass().getAnnotation(DRPdfDocument.class);
			file = o.fileName();
			break;
		}
		Document doc=null;
		if(anonDoc!=null){
			doc =  new Document(new Rectangle(anonDoc.height(), anonDoc.width()),0,0,0,0);
		}else{
			doc =  new Document(PageSize.LETTER,0,0,0,0);
		}
		FileOutputStream out= new FileOutputStream(IMGDIR+file);
		PdfWriter.getInstance(doc, out);
		doc.open();
		Object dto;
		for(int i=0;i<lista.size();i++){
			dto=lista.get(i);
			if(i>0){
				doc.newPage();
			}
			estampaEtiqueta(doc, dto, null,null);
		}

		doc.close();
		return file;
	}
    
	
	/**
	 * @see mx.dr.util.report.IPdfService#genSinglePDF(mx.dr.util.report.tag.DRPdfDocument)
	 */
	public String genSinglePDF( DRPdfObject dto) throws Exception{
		DRPdfDocument anonDoc=null;

		anonDoc = dto.getClass().getAnnotation(DRPdfDocument.class);
		Document doc=null;
		if(anonDoc!=null){
			doc =  new Document(new Rectangle(anonDoc.height(), anonDoc.width()),0,0,0,0);
		}else{
			doc =  new Document(PageSize.LETTER,0,0,0,0);
		}


		FileOutputStream out= new FileOutputStream(IMGDIR+dto.fileName());
		PdfWriter.getInstance(doc, out);
		doc.open();
		estampaEtiqueta(doc, dto, null,null);
		doc.close();
		return dto.fileName();
	}
    /**
    * write a label in pdf document.
    * <br/>
	* escribe una etiqueta en el documento pdf.
	* @param doc pdf document / documento pdf.
	* @param dto object that encompasses the values ​​of the labels to be placed in the document / objeto que engloba los valores de las etiquetas que se colocaran en el documento.
	* @param offset jump on the Y axis to be given before placing the tag in the document / salto en el eje Y que se dara antes de colocar la etiqueta en el documento.
	* @param table container table if applicable / contenedor de tabla si es que aplica.
	* @throws Exception If an error occurs / si ocurre algun error.
	*/
	public void estampaEtiqueta(Document doc, Object dto, Float offset, PdfPTable table) throws Exception{
		List<Field> fields=new ArrayList<Field>();

		for(Field m: dto.getClass().getDeclaredFields()){
			m.setAccessible(true);
			if(m.getAnnotation(DRPdfLabel.class)!=null){
				fields.add(m);
			}
		}
		Collections.sort(fields, new Comparator<Field>(){

			public int compare(Field o1, Field o2) {
				DRPdfLabel etiqueta1 = o1.getAnnotation(DRPdfLabel.class);
				DRPdfLabel etiqueta2 = o2.getAnnotation(DRPdfLabel.class);
				String uno=int2String(etiqueta1.linea())+"."+int2String(etiqueta1.orden());
				String dos=int2String(etiqueta2.linea())+"."+int2String(etiqueta2.orden());
				return uno.compareTo(dos);

			}
			private String int2String(int num){
				if(num<10){
					return "0"+num;
				}else{
					return String.valueOf(num);
				}
			}
		});
		DRPdfLabel etiqueta;
		DRPdfTable etiquetaTabla;
		int lineaActual=0;
		Paragraph pantagram=null;
		StringBuffer sb=null;
		Font font;
		Object valor;
		String label;
		DRPdfImage img;
		int residuo;
		int adicional=0;
		for(Field m: fields){
			etiqueta = m.getAnnotation(DRPdfLabel.class);
			img = m.getAnnotation(DRPdfImage.class);
			valor = m.get(dto);
			if(valor !=null && valor instanceof List){
				etiquetaTabla = m.getAnnotation(DRPdfTable.class);
				PdfPTable tableDance=null;
				if(etiquetaTabla!=null){
					tableDance=new PdfPTable(etiquetaTabla.proporcionCols());
					for(String c:etiquetaTabla.etiquetasColumna()){
						tableDance.addCell(c);
					}
				}
				if(pantagram!=null){
					doc.add(pantagram);
					pantagram = null;
				}
				for(int i=0;i<((List)valor).size();i++){
					if(i==0 &&  etiqueta.offset()>0){
						estampaEtiqueta(doc, ((List)valor).get(i), etiqueta.offset(),tableDance);
					}else{
						estampaEtiqueta(doc, ((List)valor).get(i), null, tableDance);
					}
				}
				if(etiquetaTabla!=null){
					doc.add(tableDance);
				}
			}else if(img!=null){
				/* File file = new File(IMGDIR + valor);
                    FileInputStream inImg = new FileInputStream(file);
                    byte[] b=new byte[(int)file.length()];
                    inImg.read(b);*/

				Image ima = Image.getInstance(IMGDIR + valor);

				System.out.println(ima.getPlainWidth());
				ima.scaleAbsoluteWidth(img.width());
				System.out.println(ima.getScaledWidth());
				ima.scaleAbsoluteHeight(ima.getScaledWidth());
				ima.setAlignment(img.estilo());
				ima.setAbsolutePosition(img.x(), img.y());
				doc.add(ima);



			} else if (table != null) {

				PdfPCell cerda=null;

				label = value2String(valor);
				residuo = etiqueta.longitud() - label.length();
				label = etiqueta.longitud() > 0 && residuo < 0 ? label
						.substring(0, etiqueta.longitud()) : label;
						DRPdfColumn col = m.getAnnotation(DRPdfColumn.class);
						if(col!=null){
							cerda=  new PdfPCell(new Paragraph(label));
							cerda.setColspan(col.colSpan());
							table.addCell(cerda);
						}else{
							table.addCell(label);
						}


			} else {
				if (lineaActual < etiqueta.linea()) {
					if (pantagram != null) {
						doc.add(pantagram);
					}
					if (offset == null || etiqueta.linea() > 1) {
						if (etiqueta.offset() > 0) {
							pantagram = new Paragraph(etiqueta.offset());
						} else {
							pantagram = new Paragraph();
						}
					} else {
						pantagram = new Paragraph(offset);
					}
					lineaActual = etiqueta.linea();
				}

				if (etiqueta.espaciosAntes() > 0) {
					sb = new StringBuffer("");
					llenaBlanco(etiqueta.espaciosAntes(), sb);
					font = new Font(Font.COURIER, 12);
					pantagram.add(new Chunk(sb.toString(), font));
				}
				sb = new StringBuffer("");
				label = value2String(valor);
				residuo = etiqueta.longitud() - label.length();
				label = etiqueta.longitud() > 0 && residuo < 0 ? label
						.substring(0, etiqueta.longitud()) : label;

						if (etiqueta.font().equals(BaseFont.COURIER)) {
							font = new Font(Font.COURIER, etiqueta.tamanoFont(),etiqueta.style(),new Color(etiqueta.color()[0],etiqueta.color()[1],etiqueta.color()[2]));
							adicional = 0;
						} else {
							font = FontFactory.getFont(
									TTFDIR + etiqueta.font(),
									BaseFont.CP1252, BaseFont.EMBEDDED,
									etiqueta.tamanoFont(),
									etiqueta.style(),
									new Color(etiqueta.color()[0],etiqueta.color()[1],etiqueta.color()[2]));
							adicional = label.equals("") ? (residuo / 2) + 1 : 0;
						}

						if (etiqueta.longitud() > 0
								&& etiqueta.justificado().equals(DRPdfLabel.Justicado.DER)
								&& residuo > 0) {
							llenaBlanco(residuo + adicional, sb);
						}
						sb.append(label);
						if (etiqueta.longitud() > 0
								&& etiqueta.justificado().equals(DRPdfLabel.Justicado.IZQ)
								&& residuo > 0) {
							llenaBlanco(residuo + adicional, sb);
						}
						pantagram.add(new Chunk(sb.toString(), font));
			}
		}
		if (pantagram != null) {
			doc.add(pantagram);
		}

	}
    /**
	* rellena un buffer con espacios en blanco. 
	* @param n numero de espacios en blanco.
	* @param sb buffer que se rellenara con espacios en blanco.
	*/
	private void llenaBlanco(int n, StringBuffer sb){
		for(int i=0;i< n;i++){
			sb.append(" ");
		}
	}
    /**
    * becomes a common object to string.
    * <br/>
	* convierte un objeto mas comun a string.
	* @value value object to transform into string / objeto a transformar a string.
	*/
	private String value2String(Object value){
		String s=" ";
		if(value!=null){
			if(value instanceof String){
				s = (String) value;
			}else if(value instanceof BigDecimal){
				s = def.format(value);
			}else if(value instanceof Integer){
				s = value.toString();
			}else if(value instanceof Date){
				s = df.format(value);
			}
		}
		return s;
	}
}
