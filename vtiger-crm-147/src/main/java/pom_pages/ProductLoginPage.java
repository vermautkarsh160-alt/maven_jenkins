package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLoginPage {

    // Constructor
    public ProductLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
   @FindBy(name="user_name")
   WebElement un;
   
   public WebElement getUn() {
	   return un;
   } 
	@FindBy(name="user_password")
	WebElement pwd;
	
	public WebElement getPwd() {
		return pwd;
	}
	@FindBy(id="submitButton")
	WebElement loginbtn;
	
	public WebElement getLoginBtn() {
		return loginbtn;
	}
   }

