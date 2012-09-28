/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.util.report.test;

import com.lowagie.text.Font;
import java.util.Date;

import mx.dr.util.report.tag.DRPdfImage;
import mx.dr.util.report.tag.DRPdfLabel;

/**
 *
 * @author JLMR
 */
public class ValeIN{
    
    @DRPdfLabel(linea=1,orden=10,espaciosAntes=14,justificado=DRPdfLabel.Justicado.IZQ, tamanoFont=20, offset=35)
    private String nombreEmpresa;
    
    @DRPdfLabel(linea=2,orden=10,espaciosAntes=5,justificado=DRPdfLabel.Justicado.IZQ, font="FSB2B.ttf", tamanoFont=20, offset=23)
    private String beneficioCorto1;
    
    @DRPdfLabel(linea=2,orden=20,espaciosAntes=58,justificado=DRPdfLabel.Justicado.IZQ, font="FSB2B.ttf", tamanoFont=20)
    private String beneficioCorto2;
    
    @DRPdfLabel(linea=3,orden=10,espaciosAntes=7,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=14, offset=54)
    private static final String labelNombre="Usuario: ";
    @DRPdfLabel(linea=3,orden=20,espaciosAntes=0,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=14,style=Font.BOLD)
    private String nombre;
    
    @DRPdfLabel(linea=4,orden=10,espaciosAntes=7,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=14, offset=25)
    private static final String labelId="Código de cupón: ";
    @DRPdfLabel(linea=4,orden=20,espaciosAntes=0,justificado=DRPdfLabel.Justicado.IZQ, longitud=10, font="FLO.ttf", tamanoFont=14,style=Font.BOLD)
    private String id;

    @DRPdfLabel(linea=5,orden=10,espaciosAntes=7,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=14, offset=25)
    private static final String labelCaducidad="Válido hasta: ";
    @DRPdfLabel(linea=5,orden=20,espaciosAntes=0,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=14,style=Font.BOLD)
    private Date fechaCaducidad;
    
    

    @DRPdfImage(x=50,y=600, width=100)
    @DRPdfLabel(linea=6,espaciosAntes=3)
    private String fotoAnuncio;
    
    @DRPdfLabel(linea=7,orden=10,espaciosAntes=54,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=14,style=Font.BOLD,offset=15)
    private String titulo;
    
    @DRPdfLabel(linea=10,orden=10,espaciosAntes=5,justificado=DRPdfLabel.Justicado.IZQ, font="CENTURY.TTF", tamanoFont=20, offset=47)
    private String beneficioCorto3;
    
    @DRPdfLabel(linea=10,orden=20,espaciosAntes=58,justificado=DRPdfLabel.Justicado.IZQ, font="CENTURY.TTF", tamanoFont=20)
    private String beneficioCorto4;
    
    @DRPdfLabel(linea=11,orden=3,espaciosAntes=2,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=12,style=Font.BOLD, offset=90)
    private static final String tituloBeneficios="Beneficios:";
    @DRPdfLabel(linea=12,orden=3,espaciosAntes=5,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=12)
    private String beneficios;
    
    @DRPdfLabel(linea=13,orden=10,espaciosAntes=2,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=12,style=Font.BOLD, offset=20)
    private static final String tituloCondiciones="Condiciones:";
    @DRPdfLabel(linea=14,orden=10,espaciosAntes=5,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=12)
    private String condiciones;
    
    
    @DRPdfLabel(linea=15,orden=10,espaciosAntes=2,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=12,style=Font.BOLD, offset=20)
    private static final String tituloUbicacion="Ubicacion:";
    @DRPdfLabel(linea=16,orden=10,espaciosAntes=5,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=12)
    private String direccion;
    
    
    @DRPdfLabel(linea=17,orden=3,espaciosAntes=2,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=12,style=Font.BOLD, offset=20)
    private static final String tituloInstrucciones="Cómo hacer válido tu cupón:";
    @DRPdfLabel(linea=18,orden=3,espaciosAntes=5,justificado=DRPdfLabel.Justicado.IZQ, font="FLO.ttf", tamanoFont=12)
    private static final String intruccion1="1. Imprime el cupón \n     2. Pon mucha atención a las condiciones de uso y los"+
"detalles de compra \n     3. Preséntalo en el establecimiento";
    

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

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String getIntruccion1() {
        return intruccion1;
    }

    public static String getTituloInstrucciones() {
        return tituloInstrucciones;
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

    public String getBeneficioCorto3() {
        return beneficioCorto3;
    }

    public void setBeneficioCorto3(String beneficioCorto3) {
        this.beneficioCorto3 = beneficioCorto3;
    }
    
    public String getBeneficioCorto4() {
        return beneficioCorto4;
    }

    public void setBeneficioCorto4(String beneficioCorto4) {
        this.beneficioCorto4 = beneficioCorto4;
    }


}
