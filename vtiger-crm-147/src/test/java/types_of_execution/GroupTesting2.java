package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupTesting2 {
	@Test(groups = "Smoke")
   public void case4() {
	   System.out.println("This is group testing");
	   WebDriver driver = new ChromeDriver();
	   driver.quit();
   }
   @Test(groups = "Regression")
   public void case5() {
	   System.out.println("This is group testing");
	   WebDriver driver = new ChromeDriver();
	   driver.quit();
   }
   @Test(groups = "Regression")
   public void case6() {
	   System.out.println("This is group testing");
	   WebDriver driver = new ChromeDriver();
	   driver.quit();
   }
}
