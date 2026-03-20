package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductHomePage {

    @FindBy(linkText = "Products")
    private WebElement productsLink;

    @FindBy(css = "img[title='Create Product...']")
    private WebElement createProductBtn;

    public ProductHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCreateProduct() {
        productsLink.click();
        createProductBtn.click();
    }
}