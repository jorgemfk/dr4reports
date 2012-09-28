/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.util.report.test;
import java.util.ArrayList;
import java.util.List;
import mx.dr.util.report.tag.DRCoordinateReport;
/**
 *
 * @author jorge
 */
public class RelacionVale {
    private String fecha;
    private String anuncio;
    private String mensage;

        private List<RelacionValeDetalle> detalles =  new ArrayList<RelacionValeDetalle>();
    @DRCoordinateReport(x=2,y=2)
    public String getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }

    @DRCoordinateReport(x=2,y=1)
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    @DRCoordinateReport(x=1,y=3)
    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }


    @DRCoordinateReport(y=5)
    public List<RelacionValeDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<RelacionValeDetalle> detalles) {
        this.detalles = detalles;
    }

}
