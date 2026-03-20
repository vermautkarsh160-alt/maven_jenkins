package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgCreatePage {

    // Constructor
    public OrgCreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	    @FindBy(name =  "accountname")
	    WebElement accName;
	    
	    public WebElement getAccName() {
	    	return accName;
	  }
	    @FindBy(name =  "phone")
	    WebElement phNo;
	    
	    public WebElement getPhNo() {
	    	return phNo;
	  }   
	    @FindBy(name =  "website")
	    WebElement web;
	    
	    public WebElement getWeb() {
	    	return web; 
	  }
	    @FindBy(name =  "email1")
	    WebElement email;
	    
	    public WebElement getEmail() {
	    	return email;
	  }
	   @FindBy(xpath = "//input[contains(@value, 'Save')]")
	   WebElement savebtn;
	   
	   public WebElement getSaveBtn() {
		   return savebtn;
	   }
}
