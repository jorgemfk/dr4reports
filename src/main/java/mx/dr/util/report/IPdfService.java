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
package mx.dr.util.report;

import java.io.OutputStream;
import java.util.List;


/**
 * Service that generates a PDF document.
 * <br/>
 * Servicio que genera un documento en formato PDF.
 * @author Jorge Luis Martinez Ramirez
 * @version 0.9
 * @since 13/08/2011
 * @since 0.9v
 */
public interface IPdfService {
    /**
    * Generates a document with multiple template definitions.
    * <br/> 
	* genera un documente con multiples definiciones de plantillas.
	* @param list list template definitions / lista de definiciones de plantillas.
	* @param out output which will write the result document / salida donde se escribira el documento resultado.
	**/
    public void doMultiReport( List<Object>  list, OutputStream out) throws Exception;
    /**
    * Generates a pdf document based on a single template definition.
    * <br/>
	* genera un documento pdf basado en una sola definicion de plantilla.
	* @param dto template definition / definicion de la plantilla.
	* @param out output which will write the result document / salida donde se escribira el documento resultado.
	*
	**/
    public void doReport( Object dto,  OutputStream out) throws Exception;
}

