package page_object_model_poi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceExc {
    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.facebook.com/");
    	
    	WebElement un = driver.findElement(By.name("email"));
    	un.sendKeys("admin");
    	
    	//Refresh :StaleElementReferenceException occurs
    	driver.navigate().refresh();
    	
    	//To avoid this exception we re-intialize the reference element
    	un = driver.findElement(By.name("email"));
    	un.sendKeys("admin");
    	Thread.sleep(3000);
    	
    }
}
