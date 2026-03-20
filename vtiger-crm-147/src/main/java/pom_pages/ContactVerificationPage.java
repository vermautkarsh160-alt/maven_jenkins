package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactVerificationPage {

    @FindBy(xpath = "//span[@id='dtlview_Last Name']")
    private WebElement lastNameText;

    public ContactVerificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getLastNameText() {
        return lastNameText.getText();
    }
}