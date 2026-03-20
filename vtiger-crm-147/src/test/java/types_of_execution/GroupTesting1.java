package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupTesting1 {
	@Test(groups = "Smoke")
   public void case1() {
	   System.out.println("This is group testing");
	   WebDriver driver = new ChromeDriver();
	   driver.quit();
   }
   @Test(groups = "Regression")
   public void case2() {
	   System.out.println("This is group testing");
	   WebDriver driver = new ChromeDriver();
	   driver.quit();
   }
   @Test(groups = "Smoke")
   public void case3() {
	   System.out.println("This is group testing");
	   WebDriver driver = new ChromeDriver();
	   driver.quit();
   }
}
