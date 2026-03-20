package vtiger_extra;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Email {
   public static void main(String[] args) {
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   
	   driver.get("http://localhost:8888/");
	   
	   WebElement username = driver.findElement(By.name("user_name"));
	   username.sendKeys("admin");
	   
	   WebElement password = driver.findElement(By.name("user_password"));
	   password.sendKeys("manager"); 
	   
	   driver.findElement(By.id("submitButton")).click();
	   
	   driver.findElement(By.linkText("Email")).click();
	   
	   String parentID = driver.getWindowHandle();
	  
	   driver.findElement(By.partialLinkText("Compose")).click();
	   
	   Set<String> IDs = driver.getWindowHandles();
	   
	   for(String i: IDs) {
		   driver.switchTo().window(i);
		   System.out.println(driver.getTitle().contains("Compose"));
		   break;
	   }
	   
	  driver.findElement(By.cssSelector("input[title='Select']")).click();
	   
	  WebElement web = driver.findElement(By.linkText("Mary Smith"));
	   
	  Actions act = new Actions(driver);
	  act.click(web).build().perform();
	 
	  WebElement subject = driver.findElement(By.id("subject"));
	  subject.sendKeys("Automation Script");
	  
	  driver.findElement(By.name("Send")).click();
	   
	  driver.switchTo().window(parentID);
	  driver.quit();
   }
}
