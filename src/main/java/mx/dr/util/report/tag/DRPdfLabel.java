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
package mx.dr.util.report.tag;

import com.lowagie.text.Font;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.lowagie.text.pdf.BaseFont;
/**
 * specifies the characteristics of a text label in pdf document.
 *    <br/>
 * especifica las caracteristicas de una etiqueta de texto en el documento pdf.
 * @author Jorge Luis Martinez Ramirez
 * @version 0.9
 * @since 13/08/2011
 * @since 0.9v
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DRPdfLabel {
    /**
	* enumeration of definition of justified text / enumeracion de definicion del justificado del texto.
	*/
	public enum Justicado{ IZQ,DER;};
	/**
	* specifies the name of the source file ttf generally / especifica el nombre del archivo de la fuente generalmente ttf.
	*/
	public String font() default BaseFont.COURIER;
	/**
	 * font style / estilo de la fuente.
	 */
	public int style() default Font.NORMAL;
	/**
	 * text color as rgb value. example{255,0,100} /color del texto como valor rgb.
	 */
	public int[] color() default {0,0,0};
	/**
	 * font size / tama&ntilde;o de la fuente.
	 */
	public int tamanoFont() default 12;
	/**
	 * absolute distance Y to place the label / distancia absoluta Y para colocar la etiqueta.
	*/
	public float offset() default 0.0f;
	/**
	* width of a line / anchura de una linea.
	*/
	public int linea();
	/**
	* X tag order / orden X de la etiqueta.
	*/
	public int orden() default 0;
	/**
	* number of spaces before the label / cantidad de espacios antes de la etiqueta.
    */
	public int espaciosAntes();
	/**
	* maximum length of the label if it is truncated beyond / longitud maxima de la etiqueta si se excede se es truncado.
	*/
	public int longitud() default 0;
	/**
	* justified text / justificado del texto.
	*/
	public Justicado  justificado() default Justicado.IZQ;
}
