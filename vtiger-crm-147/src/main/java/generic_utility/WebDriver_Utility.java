package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	
		WebDriver driver;
		Actions act;
		WebDriverWait wait;

		public WebDriver_Utility(WebDriver driver) {
			this.driver = driver;
			this.act = new Actions(driver);
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		}

    // 1. Maximize
    public static void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }

    // 2. Full Screen
    public static void fullScreen(WebDriver driver) {
        driver.manage().window().fullscreen();
    }

    // 3. Open URL
    public static void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    // 4. Select Drop down
    public static void selectByText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    // 5. Hover
    public static void hover(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    // 6. Right Click
    public static void rightClick(WebDriver driver, WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }

    // 7. Double Click
    public static void doubleClick(WebDriver driver, WebElement element) {
        new Actions(driver).doubleClick(element).perform();
    }

    // 8. Click And Hold
    public static void clickAndHold(WebDriver driver, WebElement element) {
        new Actions(driver).clickAndHold(element).perform();
    }

    // 9. Scroll Into View
    public void scrollIntoView(WebElement element, boolean bool) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + bool + ");", element);
	}
    
    // 10. Scroll By Offset
    public void scrollByOffset(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}

    // 11. Screenshot of Page
    public static void takePageScreenshot(WebDriver driver, String path) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path));
    }

    // 12. Screenshot of Element
    public static void takeElementScreenshot(WebElement element, String path) throws IOException {
        File src = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path));
    }

    // 13. JavaScript Click
    public static void jsClick(WebDriver driver, WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    // 14. JavaScript SendKeys
    public static void jsSendKeys(WebDriver driver, WebElement element, String value) {
    	((JavascriptExecutor)driver).executeScript("arguments[0].value=arguments[1];", element, value);
    }
    // 15. Switch Window By Title
    public static void switchToWindowByTitle(WebDriver driver, String title) {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains(title)) break;
        }
    }

    // 16. Switch Window By URL
    public static void switchToWindowByURL(WebDriver driver, String url) {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().contains(url)) break;
        }
    }

    // 17. Close All Child Windows
    public static void closeAllChildWindows(WebDriver driver) {
        String parent = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(parent);
    }
}