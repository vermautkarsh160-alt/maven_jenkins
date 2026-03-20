package crm_vtiger_organisation;

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
import org.openqa.selenium.chrome.ChromeDriver;

import pom_pages.OrgCreatePage;
import pom_pages.OrgVerificationPage;


public class CreateOrganisationProject {

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
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

        // ------- Read data from Excel ---------------
        FileInputStream fis2 = new FileInputStream("./src/test/resources/OrganisationTestData.xlsx");  // ✅ corrected

        Workbook wb = WorkbookFactory.create(fis2);

        Cell cell = wb.getSheet("org2").getRow(0).getCell(0);
        String orgName = cell.getStringCellValue() + random;
        
        
        // -------- Enter Organization Name -------------
        OrgCreatePage ocp = new OrgCreatePage(driver);
        
        //WebElement OrgName = driver.findElement(By.name("accountname"));
        ocp.getAccName().sendKeys(orgName);

        // -------- Enter Phone number -----------------------
        //WebElement PhoneNumber = driver.findElement(By.name("phone"));
        ocp.getPhNo().sendKeys("9876534367");
        
        // ------- Enter email address -----
        //WebElement web = driver.findElement(By.name("website"));
        ocp.getEmail().sendKeys("www.facebook.com");

        //---------Enter email-----------
        //WebElement Email = driver.findElement(By.name("email1"));
        ocp.getEmail().sendKeys("hipra123@gmail.com");
        
        //driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();
        ocp.getSaveBtn().click();
        
        //verification
		//String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
        
        OrgVerificationPage ovp = new OrgVerificationPage(driver);
        String actOrgName = ovp.getOrgNameText();

        if (actOrgName.contains(orgName)) {
            System.out.println("Organization created successfully !!!!");
        } else {
            System.out.println("Could not create org.....");
        }
		
		wb.close();
		fis2.close();
		fis.close();
		
//		close the browser
		Thread.sleep(3000);
		driver.quit();
    }
}
