package testNG;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFBTest {
     @Test(dataProvider = "getData")
     public void login(String username, String password) throws InterruptedException{
    	 WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	 
    	 driver.get("https://www.facebook.com/");
    	 
    	 new Actions(driver).pause(Duration.ofSeconds(2))
    	 .sendKeys(username + Keys.TAB + password + Keys.ENTER)
    	 .build().perform();
    	 
    	 Thread.sleep(2000);
    	 driver.quit();
     }
     
     @DataProvider
     public String getData() {
    	 String username = "admin133255";
    	 return username;
     }
}
