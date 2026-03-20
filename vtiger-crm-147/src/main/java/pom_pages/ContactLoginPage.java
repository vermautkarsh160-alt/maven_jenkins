package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLoginPage {

    @FindBy(name = "user_name")
    private WebElement username;

    @FindBy(name = "user_password")
    private WebElement password;

    @FindBy(id = "submitButton")
    private WebElement loginBtn;

    public ContactLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginToApp(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
    }
}