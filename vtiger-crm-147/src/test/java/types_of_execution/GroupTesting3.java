package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupTesting3 {
	@Test(groups = "Smoke")
   public void case7() {
	   System.out.println("This is group testing");
	   WebDriver driver = new ChromeDriver();
	   driver.quit();
   }
   @Test(groups = "Regression")
   public void case8() {
	   System.out.println("This is group testing");
	   WebDriver driver = new ChromeDriver();
	   driver.quit();
   }
   @Test(groups = "Smoke")
   public void case9() {
	   System.out.println("This is group testing");
	   WebDriver driver = new ChromeDriver();
	   driver.quit();
   }
}
