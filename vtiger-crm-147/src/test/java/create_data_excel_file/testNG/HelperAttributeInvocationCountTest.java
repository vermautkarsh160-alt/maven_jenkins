package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelperAttributeInvocationCountTest {
     @Test(invocationCount = 7 , threadPoolSize = 3)
     public void case1() throws InterruptedException{
    	 WebDriver driver = new ChromeDriver();
    	 Thread.sleep(3000);
    	 driver.quit();
     }
     
     @Test(enabled = false)
     public void case2() throws InterruptedException{
    	 WebDriver driver = new ChromeDriver();
    	 Thread.sleep(3000);
    	 driver.quit();
     }
}
