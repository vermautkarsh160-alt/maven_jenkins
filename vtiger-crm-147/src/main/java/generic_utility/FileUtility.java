package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropertiesFile (String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata3.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
    
	public String getDataFromPropertiesFileCampagin (String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/getDataFromPropertiesFileCampagin.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		wb.close();
		return value;
	}
	
		public static void main(String[] args) throws EncryptedDocumentException, IOException {

	        FileUtility futil = new FileUtility();

	        // Reading data from Properties file
	        String propValue = futil.getDataFromPropertiesFile("un");
	        System.out.println("Value from Properties file: " + propValue);

	        // Reading data from Excel file
	        String excelValue = futil.getDataFromExcelFile("org", 0, 0);
	        System.out.println("Value from Excel file: " + excelValue);
	    }

		
	}
