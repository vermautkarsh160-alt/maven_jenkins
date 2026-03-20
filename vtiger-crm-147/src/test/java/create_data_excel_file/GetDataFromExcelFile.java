package create_data_excel_file;

import java.io.FileInputStream;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//	FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		//
		//	Workbook wb = WorkbookFactory.create(fis);
		//
		//	Sheet sh = wb.getSheet("org");
		//
		//	Row row = sh.getRow(7);
		//
		//	Cell cell = row.getCell(0);
		//
		//	String value = cell.getStringCellValue();
		//	System.out.println(value);
		//
		//	wb.close();

		FileInputStream fis = new FileInputStream("./src/test/resources/AllTypeTestData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		// get the string value
		Cell cell = wb.getSheet("org").getRow(7).getCell(0);
		String value = cell.getStringCellValue();
		System.out.println(value);

		// get the numeric value
		double number = wb.getSheet("org").getRow(1).getCell(1).getNumericCellValue();
		System.out.println((long) number);

		// get the numeric value in string
		String number2 = wb.getSheet("org").getRow(2).getCell(1).getStringCellValue();
		System.out.println(number2);

		// get the boolean value
		boolean bool = wb.getSheet("org").getRow(4).getCell(1).getBooleanCellValue();
		System.out.println(bool);

		// get the boolean value in string
		String bool2 = wb.getSheet("org").getRow(3).getCell(1).getStringCellValue();
		System.out.println(bool2);

		wb.close();
	}
}