package mx.dr.util.report.test;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mx.dr.util.report.IPdfService;
import mx.dr.util.report.IPoiService;
import mx.dr.util.report.impl.PdfService;
import mx.dr.util.report.impl.PoiService;

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

    /**
     * PDF document test :-)
     */
    public void testPDF(){
    	MyPdfHeader vale = new MyPdfHeader();
    	vale.setTitulo("Test title");
    	vale.setNombre("Jorge Luis Martinez");
    	vale.setBeneficioCorto1("The life is great.");
    	vale.setBeneficioCorto2("dont you think?");
    	vale.setFechaCaducidad(Calendar.getInstance().getTime());
    	vale.setId("No.0000222331");
    	vale.setNombreEmpresa("My Company");
    	vale.setBeneficios("A palindrome is a word, phrase, number, or other sequence of units that may be read the same way in either direction, with general allowances for adjustments to punctuation and word dividers.");
    	vale.setFotoAnuncio("gnu.png");
    	
    	MyPdfDetail relacionValeDetalle;
    	Calendar c = Calendar.getInstance();
    	Random random = new Random();
    	for(int i=0; i<10 ; i++){
    		relacionValeDetalle = new MyPdfDetail();
    		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-i);
    		relacionValeDetalle.setDate(c.getTime());
    		relacionValeDetalle.setCode(String.valueOf(Math.abs( random.nextInt())));
    		relacionValeDetalle.setAmount(Math.abs(random.nextDouble()));
    		relacionValeDetalle.setName("data "+i);
    		vale.getDetails().add(relacionValeDetalle);
    	}
    	
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
     * Excel document Test :-)
     */
    public void testExcel()
    {

    	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	
    	MyExcelHeader relacionVale =  new MyExcelHeader();
    	relacionVale.setDate(df.format(new Date()));
    	relacionVale.setMessage("Hello DRreports!!");
    	relacionVale.setTitle("Excel Test");
    	MyExcelDetail relacionValeDetalle;
    	Calendar c = Calendar.getInstance();
    	Random random = new Random();
    	for(int i=0; i<10 ; i++){
    		relacionValeDetalle = new MyExcelDetail();
    		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-i);
    		relacionValeDetalle.setDate(c.getTime());
    		relacionValeDetalle.setCode(String.valueOf(Math.abs( random.nextInt())));
    		relacionValeDetalle.setAmount(Math.abs(random.nextDouble()));
    		relacionValeDetalle.setName("data "+i);
    		relacionVale.getDetails().add(relacionValeDetalle);
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
