package vtiger_extra;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Products {
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
		   
		   driver.findElement(By.linkText("Products")).click();
		   driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
		   driver.findElement(By.name("productname")).sendKeys("Electronics");
		   driver.findElement(By.name("serial_no")).sendKeys("9"); 
		   driver.findElement(By.name("website")).sendKeys("www.products.com");
		   driver.findElement(By.name("button")).click();
		   
		   driver.quit();
}
}