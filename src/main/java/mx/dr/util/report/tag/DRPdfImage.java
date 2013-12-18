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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.lowagie.text.Image;

/**
 * specifies that the attribute will be treated as an image in the document.
 *    <br/>
 * especifica que el atributo sera tratado como una imagen en el documento.
 * @author Jorge Luis Martinez Ramirez
 * @version 0.9
 * @since 13/08/2011
 * @since 0.9v
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DRPdfImage {
    /**
	* embedding style image / estilo de la incrustacion de la imagen.
	**/
	public int style() default Image.TEXTWRAP;
	/**
	* image width / anchura de la imagen.
    */
	public float width();
	/**
	* position x in the image / posicion x de la imagen.
	**/
	public int x();
	/**
	* position Y image / posicion y de la imagen.
	**/
	public int y();
}
