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
import java.util.ArrayList;
import java.util.List;
import mx.dr.util.report.tag.DRCoordinateReport;
/**
* Excel Header Example.
* @author Jorge Luis Martinez Ramirez
*/
public class MyExcelHeader {
    private String date;
    private String title;
    private String message;
    private List<MyExcelDetail> details =  new ArrayList<MyExcelDetail>();
    

       
    /**
	 * @return the date
	 */
    @DRCoordinateReport(x=2,y=1)
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the title
	 */
	@DRCoordinateReport(x=2,y=2)
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@DRCoordinateReport(x=1,y=3)
    public String getMessage() {
        return message;
    }

    public void setMessage(String mensage) {
        this.message = mensage;
    }


    @DRCoordinateReport(y=5)
    public List<MyExcelDetail> getDetails() {
        return details;
    }

    public void setDetails(List<MyExcelDetail> detalles) {
        this.details = detalles;
    }

}
