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

import java.io.InputStream;
import java.io.OutputStream;
/**
* Service that generates an Excel document.
* <br/>
* Servicio que genera un documento en formato excel.
* @author Jorge Luis Martinez Ramirez
* @version 0.9
* @since 13/08/2011
* @since 0.9v
*/
public interface IPoiService {
    /**
    * Based on the configuration of the object generates the excel report. 
    * <br/>
	* basado en la configuracion del objeto genera el reporte excel. 
	* @param is InputStream reading excel base template / inputstream de lectura de la plantilla base de excel.
	* @param dto object that defines the settings and values ​​filling the information / objeto que define la configuracion y valores del llenado de la informacion.
	* @param out output which will write the result document / salida donde se escribira el documento resultado.
	*/
	public void doReport(InputStream is, Object dto, OutputStream out) throws Exception;
}
