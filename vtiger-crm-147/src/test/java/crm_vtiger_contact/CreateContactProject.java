package crm_vtiger_contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom_pages.ContactCreatePage;
import pom_pages.ContactHomePage;
import pom_pages.ContactLoginPage;
import pom_pages.ContactVerificationPage;


public class CreateContactProject{

    public static void main(String[] args) throws IOException, Throwable {

        // Generate random number to make contact unique
        int random = new Random().nextInt(999);

        // ------------------ Read common data ------------------
        FileInputStream fis = new FileInputStream("./src/test/resources/commondata3.properties");
        Properties pObj = new Properties();
        pObj.load(fis);

        String USERNAME = pObj.getProperty("un");
        String PASSWORD = pObj.getProperty("pwd");
        String URL = pObj.getProperty("url");

        // ------------------ Launch Browser -------------------
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(URL);

        // ------------------ Login ---------------------------
        ContactLoginPage lp = new ContactLoginPage(driver);
        lp.loginToApp(USERNAME, PASSWORD);

        // ------------------ Navigate to Create Contact -------
        ContactHomePage chp = new ContactHomePage(driver);
        chp.clickCreateContact();

        // ------------------ Read Excel Data -----------------
        FileInputStream fis2 = new FileInputStream("./src/test/resources/ContactTestData.xlsx.xlsx");
        Workbook wb = WorkbookFactory.create(fis2);

        Cell cell = wb.getSheet("org3").getRow(0).getCell(0);
        String lastName = cell.getStringCellValue() + random;  // Last Name

        // ------------------ Fill Contact Form ----------------
        ContactCreatePage ccp = new ContactCreatePage(driver);
        ccp.createContact(lastName, "9876534367", "Contact Information", "shipra123@gmail.com");

        // ------------------ Wait for Verification Element ----
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.xpath("//span[@id='dtlview_Last Name']")));

        // ------------------ Verification --------------------
        ContactVerificationPage cvp = new ContactVerificationPage(driver);
        String actualLastName = cvp.getLastNameText();

        System.out.println("Expected Last Name: " + lastName);
        System.out.println("Actual Last Name: " + actualLastName);

        if (actualLastName.contains(lastName)) {
            System.out.println("Contact created successfully !!!!");
        } else {
            System.out.println("Could not create contact.....");
        }

        // ------------------ Close Resources -----------------
        wb.close();
        fis2.close();
        fis.close();

        Thread.sleep(3000);
        driver.quit();
    }
}