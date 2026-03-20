package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgHomePage {

    // Constructor
    public OrgHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText =  "Organizations")
    WebElement orglink;
    
    public WebElement orgLink() {
    	return orglink;
    }
    
    @FindBy(css = "img[title='Create Organization...'")
    WebElement createtab;
    
    public WebElement createTab() {
    	return createtab;
    }
}
