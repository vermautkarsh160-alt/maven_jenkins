package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatePage {

    @FindBy(name = "productname")
    private WebElement productName;

    @FindBy(name = "serial_no")
    private WebElement serialNumber;

    @FindBy(name = "website")
    private WebElement website;

    @FindBy(name = "button")
    private WebElement saveBtn;

    public ProductCreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createProduct(String pname, String serial, String web) {
        productName.sendKeys(pname);
        serialNumber.sendKeys(serial);
        website.sendKeys(web);
        saveBtn.click();
    }

    public WebElement getSaveBtn() {
        return saveBtn;
    }
}