package testNG;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoTest {
	     @Test(dataProvider = "getData")
	     public void login(String username, String password) throws InterruptedException{
	    	 WebDriver driver = new ChromeDriver();
	    	 driver.manage().window().maximize();
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    	 
	    	 driver.get("https://www.saucedemo.com/");
	    	 
	    	 new Actions(driver).pause(Duration.ofSeconds(2))
	    	 .sendKeys(username + Keys.TAB + password + Keys.ENTER)
	    	 .build().perform();
	    	 
	    	 Thread.sleep(2000);
	    	 driver.quit();
	     }
	     
	     @DataProvider
	     public String[][] getData(){
			String[][] crad = new String[5][2];
			
			crad[0][0] = "standard_user";
			crad[0][1] = "secret_sauce";
			
			crad[1][0] = "locked_out_user";
			crad[1][1] = "secret_sauce";
			
			crad[2][0] = "problem_user";
			crad[2][1] = "secret_sauce";
			
			crad[3][0] = "performance_glitch_user";
			crad[3][1] = "secret_sauce";
			
			crad[4][0] = "error_user";
			crad[4][1] = "secret_sauce";
			
			crad[4][0] = "visual_user";
			crad[4][1] = "Ssecret_sauce";
			
			return crad;
			
		} 
}