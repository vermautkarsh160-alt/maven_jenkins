package page_object_model_poi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindByAnnotationFacebook{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		FacebookLoginPageTest lp = new FacebookLoginPageTest(driver);
		lp.ele.sendKeys("admin");
		Thread.sleep(3000);
		driver.quit();
	}
}
class FacebookLoginPageTest {
	WebDriver driver;

    // Constructor
    FacebookLoginPageTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }
	   //WebElement ele = driver.findElement(By.name("email"));
		//Instead of writing above line we come-up with @FindBy annotation in selenium
		@FindBy(name="email")
		WebElement ele;
	}