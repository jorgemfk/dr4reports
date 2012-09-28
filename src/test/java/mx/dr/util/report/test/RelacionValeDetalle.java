/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.util.report.test;

import mx.dr.util.report.tag.DRCoordinateReport;

/**
 *
 * @author jorge
 */
public class RelacionValeDetalle {
    private String idVale;
    private String nombre;
    private String fecha;

    @DRCoordinateReport(x=0)
    public String getIdVale() {
        return idVale;
    }

    public void setIdVale(String idVale) {
        this.idVale = idVale;
    }
    @DRCoordinateReport(x=1)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @DRCoordinateReport(x=2)
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



}
