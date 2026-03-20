package crm_vtiger_product;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom_pages.ProductCreatePage;
import pom_pages.ProductHomePage;
import pom_pages.ProductLoginPage;
import pom_pages.ProductVerificationPage;

public class CreateProductProjectDeno {

    public static void main(String[] args) throws IOException, Throwable {

        int random = new Random().nextInt(999);

        // ---------------- Read property file ----------------
        FileInputStream fis = new FileInputStream("./src/test/resources/commondata3.properties");
        Properties pObj = new Properties();
        pObj.load(fis);

        String USERNAME = pObj.getProperty("un");
        String PASSWORD = pObj.getProperty("pwd");
        String URL = pObj.getProperty("url");

        // ---------------- Launch browser -------------------
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(URL);

        try {
            // ---------------- Login ---------------------------
            ProductLoginPage lp = new ProductLoginPage(driver);
            lp.getUn().sendKeys(USERNAME);
            lp.getPwd().sendKeys(PASSWORD);
            lp.getLoginBtn().click();

            // ---------------- Navigate to Create Product -------
            ProductHomePage php = new ProductHomePage(driver);
            php.clickCreateProduct();

            // ---------------- Read Excel -----------------------
            FileInputStream fis2 = new FileInputStream("./src/test/resources/ProductTestData.xlsx");
            Workbook wb = WorkbookFactory.create(fis2);

            // Sheet check
            Sheet sheet = wb.getSheet("org3");
            if (sheet == null) {
                System.out.println("ERROR: Sheet 'org3' not found in Excel!");
                wb.close();
                fis2.close();
                driver.quit();
                return;
            }

            Cell cell = sheet.getRow(0).getCell(0);
            String productName = cell.getStringCellValue() + random;

            // ---------------- Fill Product Form ----------------
            ProductCreatePage pcp = new ProductCreatePage(driver);
            pcp.createProduct(productName, "9", "www.products.com");

            // ---------------- Wait for verification ------------
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    org.openqa.selenium.By.id("dtlview_Product Name")));

            // ---------------- Verification --------------------
            ProductVerificationPage pvp = new ProductVerificationPage(driver);
            String actualProductName = pvp.getProductNameText();

            System.out.println("Expected Product Name: " + productName);
            System.out.println("Actual Product Name: " + actualProductName);

            if (actualProductName.contains(productName)) {
                System.out.println("Product created successfully !!!!");
            } else {
                System.out.println("Could not create product.....");
            }

            // ---------------- Close Excel ----------------------
            wb.close();
            fis2.close();

        } finally {
            // ---------------- Close resources -----------------
            fis.close();
            Thread.sleep(2000);
            driver.quit();
        }
    }
}