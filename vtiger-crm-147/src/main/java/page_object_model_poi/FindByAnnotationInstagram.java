package page_object_model_poi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class InstagramTest{
	//initialization
	WebDriver driver;
	InstagramTest(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	//Access
	@FindBy(name="email")
	WebElement un;
}
//utilization
class FindByAnnotationInstagram {
	 public static void main(String[] args) throws InterruptedException {
     WebDriver driver = new ChromeDriver();
     driver.get("https://www.facebook.com/");
     InstagramTest insta = new InstagramTest(driver);
     insta.un.sendKeys("admin");
     Thread.sleep(3000);
     driver.quit();
 }
}