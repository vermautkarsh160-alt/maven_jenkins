package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductVerificationPage {

    @FindBy(id = "dtlview_Product Name")
    private WebElement productNameText;

    public ProductVerificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getProductNameText() {
        return productNameText.getText();
    }
}