package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactCreatePage {

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "mobile")
    private WebElement mobile;

    @FindBy(name = "title")
    private WebElement title;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "button")
    private WebElement saveBtn;

    public ContactCreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createContact(String lname, String mob, String ttl, String mail) {
        lastName.sendKeys(lname);
        mobile.sendKeys(mob);
        title.sendKeys(ttl);
        email.sendKeys(mail);
        saveBtn.click();
    }

    public WebElement getSaveBtn() {
        return saveBtn;
    }
}