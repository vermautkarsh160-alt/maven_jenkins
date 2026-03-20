
package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgVerificationPage {

    @FindBy(id = "dtlview_Organization Name")
    private WebElement orgNameText;

    // Constructor
    public OrgVerificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Getter method
    public String getOrgNameText() {
        return orgNameText.getText();
    }
}