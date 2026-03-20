package vtiger_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Organisations {
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
		   
		   driver.findElement(By.linkText("Organizations")).click();
		   driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		   driver.findElement(By.name("accountname")).sendKeys("Qspiders");
		   driver.findElement(By.name("phone")).sendKeys("9876534367"); 
		   driver.findElement(By.name("email1")).sendKeys("shipra123@gmail.com");
		   driver.findElement(By.name("button")).click();
		   driver.quit();
	}	   
}
