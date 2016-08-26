import static org.junit.Assert.assertEquals;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class basisAlertHandlingUeben{
	
	static WebDriver driver;
	
	@BeforeClass
	public static void BrowserAufrufen() {
		
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.compendiumdev.co.uk/selenium/alerts.html");

	}
	

	@Test
	public void basicAlertHandlingBeispiel() throws InterruptedException{
		//WEbElemente die man beim Testen braucht.
		WebElement alertButton01 = driver.findElement(By.id("alertexamples"));
		WebElement alertConfirmButton = driver.findElement(By.id("confirmexample"));
		WebElement alertPrompButton = driver.findElement(By.id("promptexample"));
		WebElement alertConfirmReturn = driver.findElement(By.id("confirmreturn"));
		WebElement alertPrompReturn = driver.findElement(By.id("promptreturn"));
		
		
		
		alertButton01.click();
		String alertMessage = "I am an alert box!";
		assertEquals(alertMessage, driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		
		alertConfirmButton.click();
		driver.switchTo().alert().dismiss();
		assertEquals("false", alertConfirmReturn.getText());
		
		alertConfirmButton.click();
		driver.switchTo().alert().accept();
		assertEquals("true", alertConfirmReturn.getText());
		
		alertPrompButton.click();
		driver.switchTo().alert().sendKeys("Mein erster Test");
		driver.switchTo().alert().accept();
		assertEquals("Mein erster Test", alertPrompReturn.getText());
		
	}
	
		@AfterClass
		public static void schliessenBrowser(){
			driver.quit();
		}

}
