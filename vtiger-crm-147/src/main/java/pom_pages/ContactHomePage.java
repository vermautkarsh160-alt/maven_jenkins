package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactHomePage {

    @FindBy(linkText = "Contacts")
    private WebElement contactsLink;

    @FindBy(css = "img[alt='Create Contact...']")
    private WebElement createContactBtn;

    public ContactHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCreateContact() {
        contactsLink.click();
        createContactBtn.click();
    }
}