import static org.junit.Assert.assertEquals;

import java.sql.Driver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class switchToFrameUebung {
	
static WebDriver driver;
static WebDriverWait wait;
	
	@BeforeClass
	public static void BrowserAufrufen() {
		
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.compendiumdev.co.uk/selenium/frames");
		//wait = new WebDriverWait(driver, .DEFAULT_TIMEOUT_SECONDS);
	}
	
	@Test
	public void switchToFrameExample(){
		
		assertEquals("Frameset Example Title (Example 6)", driver.getTitle());
		
		driver.switchTo().frame("menu");
		
		driver.findElement(By.cssSelector("a[hrf='frames_example_1.html']")).click();
		String titleForExample1 = "Frameset Example Title (Example 1)";
		
		WebDriverWait warte = new WebDriverWait (driver, 10);
		warte.until(ExpectedConditions.titleIs(titleForExample1));
		
		assertEquals(titleForExample1, driver.getTitle());
		
	}

	
		@AfterClass
		public static void schliessenBrowser(){
			driver.quit();
		}


}
