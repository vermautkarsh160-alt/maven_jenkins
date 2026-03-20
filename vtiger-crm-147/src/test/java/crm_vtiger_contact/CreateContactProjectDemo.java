package crm_vtiger_contact;

import java.io.FileInputStream;


import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactProjectDemo {

    public static void main(String[] args) throws IOException, Throwable {

        // Generate Random Number
        int random = new Random().nextInt(999);

        // ------ Read Data From Property File ------------
        FileInputStream fis = new FileInputStream("./src/test/resources/commondata3.properties");  // ✅ corrected

        Properties pObj = new Properties();
        pObj.load(fis);

        String USERNAME = pObj.getProperty("un");
        String URL = pObj.getProperty("url");
        String PASSWORD = pObj.getProperty("pwd");

        // ------ Launch Browser -----------
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(URL);

        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();

        // ----------- Navigate to  ---------Contact---------
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

        // ------- Read data from Excel ---------------
        FileInputStream fis2 = new FileInputStream("./src/test/resources/ContactTestData.xlsx.xlsx");  // ✅ corrected

        Workbook wb = WorkbookFactory.create(fis2);

        Cell cell = wb.getSheet("org3").getRow(0).getCell(0);
        String orgName = cell.getStringCellValue() + random;

        System.out.println(orgName);

        // -------- Enter Organization Name -------------
        WebElement LastName = driver.findElement(By.name("lastname"));
        LastName.sendKeys("Verma");
        System.out.println(LastName);

        // -------- Enter Phone number -----------------------
        WebElement PhoneNumber = driver.findElement(By.name("mobile"));
        PhoneNumber.sendKeys("9876534367");
        System.out.println(PhoneNumber);

        // ------- Enter email address -----
        WebElement Title = driver.findElement(By.name("title"));
        Title.sendKeys("Contact Information");
        System.out.println(Title);

        //---------Enter email-----------
        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys("shipra123@gmail.com");
        System.out.println(Email);
        
        driver.findElement(By.name("button")).click();

        // -------- Close resources properly ----------
        wb.close();
        fis2.close();
        fis.close();
        driver.quit();
    }
}
