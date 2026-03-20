package create_data_excel_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateAndReadDataInExcel {
   public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/CreateAndReadData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	
	//when we fetch the data => getCell()
	//Cell cell = wb.getSheet("Fetch").getRow(1).getCell(0);
	//String LastName = cell.getStringCellValue();
	//System.out.println(LastName);
	
	//When we write the data => createCell()
	Cell cell2 = wb.getSheet("Fetch").getRow(4).createCell(0);
	
	//set the data
	cell2.setCellValue("kumar");
	
	//save the data
	FileOutputStream fos = new FileOutputStream("./src/test/resources/CreateAndReadData.xlsx");
	wb.write(fos); //=>save
	
	//don't forget to close the wb
	wb.close();
    }
}
