package testNG;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//No. of rows = No. of Executions
//No. of columns = No. of data
public class HelperAttributeDataProviderTest {
	@Test(dataProvider = "getData")
     public void login(String username, String password) throws InterruptedException{
    	 WebDriver driver = new ChromeDriver();
    	 driver.get("https:/www.facebook.com");
    	 
    	//String username = "admin";
    	//String password = "admin@1314";
    	 
    	 new Actions(driver).pause(Duration.ofSeconds(1)).sendKeys(username + Keys.TAB + password + Keys.ENTER).build().perform();
    	 driver.quit();
     }
	@DataProvider
     public String[][] getData(){
		String[][] crad = new String[5][2];
		
		crad[0][0] = "Kashif";
		crad[0][1] = "Kashif@123";
		
		crad[1][0] = "Kashi";
		crad[1][1] = "Kashi@134";
		
		crad[2][0] = "Shipra";
		crad[2][1] = "Shipra123";
		
		crad[3][0] = "Verma";
		crad[3][1] = "Verma123";
		
		crad[4][0] = "Supriya";
		crad[4][1] = "Supriya123";
		
		return crad;
		
	}
}
