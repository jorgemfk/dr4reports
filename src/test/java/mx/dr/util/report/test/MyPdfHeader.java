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
package mx.dr.util.report.test;

import com.lowagie.text.Font;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.dr.util.report.tag.DRPdfImage;
import mx.dr.util.report.tag.DRPdfLabel;
import mx.dr.util.report.tag.DRPdfTable;

/**
* PDF Example.
* @author Jorge Luis Martinez Ramirez
*/
public class MyPdfHeader{
    
    @DRPdfLabel(y=1,order=10,wspacesBefore=0,justified=DRPdfLabel.JUSTIFIED.DER, fontSize=20, offset=35, length=50)
    private String nombreEmpresa;
    
    @DRPdfLabel(y=2,order=10,wspacesBefore=5,justified=DRPdfLabel.JUSTIFIED.IZQ, font="FSB2B.ttf", fontSize=20, offset=23)
    private String beneficioCorto1;
    
    @DRPdfLabel(y=2,order=20,wspacesBefore=58,justified=DRPdfLabel.JUSTIFIED.IZQ, font="FSB2B.ttf", fontSize=20)
    private String beneficioCorto2;
    
    @DRPdfLabel(y=3,order=10,wspacesBefore=7,justified=DRPdfLabel.JUSTIFIED.IZQ, fontSize=14, offset=24)
    private static final String labelNombre="User: ";
    @DRPdfLabel(y=3,order=20,wspacesBefore=0,justified=DRPdfLabel.JUSTIFIED.IZQ, font="FLO.ttf", fontSize=14,style=Font.BOLD)
    private String nombre;
    
    @DRPdfLabel(y=4,order=10,wspacesBefore=7,justified=DRPdfLabel.JUSTIFIED.IZQ, fontSize=14, offset=100)
    private static final String labelId="Code: ";
    @DRPdfLabel(y=4,order=20,wspacesBefore=0,justified=DRPdfLabel.JUSTIFIED.IZQ, length=10, font="FLO.ttf", fontSize=14,style=Font.BOLD)
    private String id;

    @DRPdfLabel(y=5,order=10,wspacesBefore=7,justified=DRPdfLabel.JUSTIFIED.IZQ, font="FLO.ttf", fontSize=14, offset=25)
    private static final String labelCaducidad="Date: ";
    @DRPdfLabel(y=5,order=20,wspacesBefore=0,justified=DRPdfLabel.JUSTIFIED.IZQ, font="FLO.ttf", fontSize=14,style=Font.BOLD)
    private Date fechaCaducidad;
    
    

    @DRPdfImage(x=50,y=600, width=100)
    @DRPdfLabel(y=6,wspacesBefore=3)
    private String fotoAnuncio;
    
    @DRPdfLabel(y=5,order=30,wspacesBefore=24,justified=DRPdfLabel.JUSTIFIED.IZQ, font="FLO.ttf", fontSize=14,style=Font.BOLD,offset=15,color={255,0,0})
    private String titulo;
    
    
    @DRPdfLabel(y=8,order=3,wspacesBefore=2,justified=DRPdfLabel.JUSTIFIED.IZQ, fontSize=12,style=Font.BOLD, offset=90)
    private static final String tituloBeneficios="Some Text:";
    @DRPdfLabel(y=9,order=3,wspacesBefore=5,justified=DRPdfLabel.JUSTIFIED.IZQ, font="FLO.ttf", fontSize=12)
    private String beneficios;
    
    @DRPdfLabel(wspacesBefore=0,y=7,offset=100f)
    @DRPdfTable(colsPercentage={0.25f, 0.25f, 0.25f, 0.25f},columnLabels={"Code", "Name", "Date", "Amount"})
    private List<MyPdfDetail> details =  new ArrayList<MyPdfDetail>();
    
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getFotoAnuncio() {
        return fotoAnuncio;
    }

    public void setFotoAnuncio(String fotoAnuncio) {
        this.fotoAnuncio = fotoAnuncio;
    }
     

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getBeneficioCorto1() {
        return beneficioCorto1;
    }

    public void setBeneficioCorto1(String beneficioCorto1) {
        this.beneficioCorto1 = beneficioCorto1;
    }
    
    public String getBeneficioCorto2() {
        return beneficioCorto2;
    }

    public void setBeneficioCorto2(String beneficioCorto2) {
        this.beneficioCorto2 = beneficioCorto2;
    }

	/**
	 * @return the details
	 */
	public List<MyPdfDetail> getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(List<MyPdfDetail> details) {
		this.details = details;
	}



}
