package advance_reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;

@Listeners(listeners.List_Imp.class)
public class LoginTest {
	ExtentReports report;

	@BeforeSuite
	public void repConfig() {
		
	}
	public static WebDriver sdriver;
	
	@Test
	public void fbLoginTest() {
		WebDriver driver = new ChromeDriver();
		sdriver = driver;
		
		driver.get("https://www.facebook.com/");
	
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "fbLoginTest")
	public void xLoginTest() {
	}
	
	@Test
	public void instaLoginTest() {
		
	}
	
	@AfterSuite
	public void repBackup() {

	}
}