package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Parameters("bro")
@Test
public class CrossBrowserTesting1 {
     public void CBT(String browser) {
    	 WebDriver driver = null;
    	 
    	 if(browser.equals("chrome")) {
    		driver = new ChromeDriver(); 
    	 }else if(browser.equals("edge")) {
    		driver = new EdgeDriver();
    	 }else if(browser.equals("firefox")) {
    		driver = new FirefoxDriver();
    	 }else {
    		driver = new ChromeDriver();
    	 }
    	 driver.quit();
     }
}
