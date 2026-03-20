package vtiger_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

class  FileUtilityDemo{
		 int rowNum;
		 String sheetName;

		 public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws IOException {

		        FileInputStream fis = new FileInputStream("./data/testdata.xlsx");
		        Workbook wb = WorkbookFactory.create(fis);

		        Sheet sheet = wb.getSheet(sheetName);
		        Row row = sheet.getRow(rowNum);
		        Cell cell = row.getCell(cellNum);
		            
		        wb.close();
		        fis.close();

		        return cell.toString();
	}
	
}

public class getDataFromExcelFile {
     public static void main(String[] args) throws IOException {
    	 FileUtilityDemo fud = new FileUtilityDemo();
    	 String lastName = fud.getDataFromExcelFile("org",2, 0);
    	 System.out.println(lastName);
     }
}
