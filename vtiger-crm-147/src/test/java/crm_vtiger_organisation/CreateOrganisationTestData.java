package crm_vtiger_organisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class CreateOrganisationTestData {
public static void main(String[] args) throws InterruptedException,IOException {
	    	
	    	//Get the data from properties file
	    	FileInputStream fis1 = new FileInputStream("./src/test/resources/commondata3.properties");
	    	
	    	Properties pObj = new Properties();
	    	pObj.load(fis1);
	    	
	    	String BROWSER = pObj.getProperty("bro");
	    	String USERNAME = pObj.getProperty("un");
	    	String URL = pObj.getProperty("url");
	    	String PASSWORD = pObj.getProperty("pwd");
	    	

	    	System.out.println(BROWSER);
	    	System.out.println(USERNAME);
	        System.out.println(URL);
	        System.out.println(PASSWORD);
	    	
	    	int random = (int) (Math.random()*999);
	    	
	    	//Get data from excel file
	    	FileInputStream fis2 = new FileInputStream("./src/test/resources/TestData.xlsx.xlsx");
	    	//By using Apache POI tool and workbookfactory class
	    	Workbook wb = WorkbookFactory.create(fis2);
	        Cell cell = wb.getSheet("org").getRow(4).getCell(0);
	        String orgName = cell.getStringCellValue()+random;
	    	System.out.println(orgName);
	}	}
