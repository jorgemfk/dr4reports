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

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


import mx.dr.util.report.tag.DRCoordinateLabelReport;
import mx.dr.util.report.tag.DRCoordinateReport;
import mx.dr.util.report.tag.DRRelativeCoordinateReport;
import mx.dr.util.report.dto.CellDTO;
import mx.dr.util.report.IPoiService;
/**
 * Excel service implementation.
 *  <br/>
 * Implementacion del servicio excel.
 * @author Jorge Luis Martinez Ramirez
 * @version 0.9
 * @since 13/08/2011
 * @since 0.9v
 */
public class PoiService implements IPoiService {
	/**
	 * @see mx.dr.util.report.IPoiService#doReport(InputStream, Object, OutputStream)
	 */
	public void doReport(InputStream is, Object dto, OutputStream out) throws Exception{

		POIFSFileSystem fs=null;
		HSSFWorkbook wb=null;

		fs = new POIFSFileSystem (is);

		wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		DRCoordinateReport anotCoordenada;
		DRCoordinateLabelReport anotEtiqueta;
		DRRelativeCoordinateReport anotRelativa;
		Object valor;
		Object valor2;


		HSSFRow row;
		HSSFCell cerda;
		int offset;

		CellDTO celdaDto;

		for(Method method: dto.getClass().getMethods()){
			anotEtiqueta =  method.getAnnotation(DRCoordinateLabelReport.class);
			if(anotEtiqueta!=null){
				dto.getClass().getMethod("set"+method.getName().substring(3), CellDTO.class)
				.invoke(dto,
						new CellDTO(sheet.getRow(anotEtiqueta.y()).getCell(anotEtiqueta.x()).getCellStyle(),
								sheet.getRow(anotEtiqueta.y()).getCell(anotEtiqueta.x()).getRichStringCellValue()));
			}
		}


		for(Method method: dto.getClass().getMethods()){
			anotCoordenada = method.getAnnotation(DRCoordinateReport.class);
			if(anotCoordenada!=null){
				valor = method.invoke(dto);
				if(valor!=null){
					cerda = sheet.getRow(anotCoordenada.y()).getCell(anotCoordenada.x());
					ingresaValor(cerda, valor);
					if(valor instanceof List){
						offset=anotCoordenada.y();
						int index=0;
						while(index<((List)valor).size()){
							Object detalle = ((List)valor).get(index);
							row= sheet.createRow(index+offset);
							for(Method methodMan: detalle.getClass().getMethods()){
								anotCoordenada = methodMan.getAnnotation(DRCoordinateReport.class);
								if(anotCoordenada!=null){
									cerda = row.createCell(anotCoordenada.x());
									valor2 = methodMan.invoke(detalle);
									if(valor2!=null){
										ingresaValor(cerda, valor2);
									}
								}
							}
							index++;	
						}
						index-=1;
						for(Method m: dto.getClass().getMethods()){
							anotEtiqueta =  m.getAnnotation(DRCoordinateLabelReport.class);
							anotRelativa = m.getAnnotation(DRRelativeCoordinateReport.class);
							if(anotEtiqueta!=null){
								row=sheet.getRow(anotEtiqueta.y()+index);
								if(row==null){
									row=sheet.createRow(anotEtiqueta.y()+index);
								}
								cerda = row.createCell(anotEtiqueta.x());
								celdaDto = (CellDTO) m.invoke(dto); 
								cerda.setCellStyle(celdaDto.getStyle());
								cerda.setCellValue(celdaDto.getLabel());
							}else if(anotRelativa!=null){
								row=sheet.getRow(anotRelativa.y()+index);
								if(row==null){
									row=sheet.createRow(anotRelativa.y()+index);
								}
								cerda = row.createCell(anotRelativa.x());
								valor2 = m.invoke(dto);
								if(valor2!=null){
									ingresaValor(cerda, valor2);
								}
							}
						}
					}
				}	
			}
		}
		//String res = "/mailConfig.properties";
		//tempPath=PoiService.class.getResource(res).getPath().replaceFirst(res, "")
		//        + "/../../" + Labels.getLabel("parametro.adjuntos.folder") + "/" + archivo;
		//FileUtils.writeToFile(archivo,new ByteArrayInputStream(doc.getDataContent()));

		//tempPath = this.getPath(TEMP_DIR)+"\\"+archivo;
		wb.write(out);//new FileOutputStream(tempPath ,false));


	}

	/**
	 * type a cell value to the document.
	 * <br/>
	 * ingresa el valor a una celda del documento.
	 * @param cell cell that will be assigned the value / celda a la que se le asignara el valor.
	 * @param value value entered in cell / valor que se introducira en la celda.
	 */
	private void ingresaValor(HSSFCell cell, Object value){
		if(value instanceof String){
			cell.setCellValue(new HSSFRichTextString((String)value));
		}else if(value instanceof Character){
			cell.setCellValue(new HSSFRichTextString(""+value));
		}else if(value instanceof Integer||value instanceof Long||value instanceof Float){
			cell.setCellValue(new HSSFRichTextString(value.toString()));
		}else if(value instanceof BigDecimal){
			cell.setCellValue(((BigDecimal)value).doubleValue());
		}else if(value instanceof Date){
			cell.setCellValue((Date)value);
		}else if(value instanceof Double){
			cell.setCellValue((Double)value);
		}
	}
}
