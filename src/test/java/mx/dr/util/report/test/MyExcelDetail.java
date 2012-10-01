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

import java.util.Date;

import mx.dr.util.report.tag.DRCoordinateReport;

/**
* Excel Detail Example.
* @author Jorge Luis Martinez Ramirez
*/
public class MyExcelDetail {
    private String code;
    private String name;
    private Date date;
    private Double amount;

    @DRCoordinateReport(x=0)
    public String getCode() {
        return code;
    }

    public void setCode(String idVale) {
        this.code = idVale;
    }
    @DRCoordinateReport(x=1)
    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }
    @DRCoordinateReport(x=2)
    public Date getDate() {
        return date;
    }

    public void setDate(Date fecha) {
        this.date = fecha;
    }

	/**
	 * @return the amount
	 */
    @DRCoordinateReport(x=3)
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}



}
