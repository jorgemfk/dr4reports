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
package mx.dr.util.report.dto;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
/**
* Value and style of a cell in excel. 
* <br/>
* Valor y estilo de una celda en excel.
* @author Jorge Luis Martinez Ramirez
* @version 0.9
* @since 13/08/2011
* @since 0.9v
*/
public class CellDTO {
    /**
	* Cell style in the document / estilo de la celda en el documento.
	*/
	HSSFCellStyle style;
	/**
	* Cell value / valor de la celda.
	*/
	HSSFRichTextString label;
	
	/**
	* Default constructor.
	* <br/>
	* Contructor por defecto.
	* @param style cell style in the document / estilo de la celda en el documento.
	* @param label Cell value / valor de la celda.
	*
	*/
	public CellDTO(HSSFCellStyle style, HSSFRichTextString label) {
		super();
		this.style = style;
		this.label = label;
	}
	
	/**
	* @return the style.
	*/
	public HSSFCellStyle getStyle() {
		return style;
	}
	
	/**
	* @return the label.
	*/
	public HSSFRichTextString getLabel() {
		return label;
	}
}
