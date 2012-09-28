package mx.dr.util.report.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import mx.dr.util.report.IPdfService;
import mx.dr.util.report.IPoiService;
import mx.dr.util.report.impl.PdfService;
import mx.dr.util.report.impl.PoiService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testPDF(){
    	ValeIN vale = new ValeIN();
    	vale.setTitulo("titulo de prueba");
    	vale.setNombre("Jorge Luis Martinez");
    	vale.setFotoAnuncio("gnu.png");
    	IPdfService pdfService = new PdfService();
    	try {
    		File file = new File("./report.pdf");
			pdfService.doReport(vale, new FileOutputStream(file));
			System.out.println("the pdf report was generated on: " + file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
    	assertTrue( true );
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {

    	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	
    	RelacionVale relacionVale =  new RelacionVale();
    	relacionVale.setFecha(df.format(new Date()));
    	relacionVale.setMensage("Hello DRreports!!");
    	
    	RelacionValeDetalle relacionValeDetalle;
    	Calendar c = Calendar.getInstance();
    	Random random = new Random();
    	for(int i=0; i<10 ; i++){
    		relacionValeDetalle = new RelacionValeDetalle();
    		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-i);
    		relacionValeDetalle.setFecha(df.format(c.getTime()));
    		relacionValeDetalle.setIdVale(String.valueOf(Math.abs( random.nextInt())));
    		relacionValeDetalle.setNombre("data "+i);
    		relacionVale.getDetalles().add(relacionValeDetalle);
    	}
    	
    	IPoiService poiService =  new PoiService();
    	try {
    		File file = new File("./report.xls");
			poiService.doReport(AppTest.class.getResourceAsStream("/mx/dr/util/report/test/valetemplate.xls"), relacionVale, new FileOutputStream(file));
			System.out.println("the excel report was generated on: " + file.getAbsolutePath());
    	} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
    	
    	assertTrue( true );
    }
}
