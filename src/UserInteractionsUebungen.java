import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserInteractionsUebungen {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void erstelleDriverUndBesucheTestseite() {
		
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.compendiumdev.co.uk/selenium/gui_user_interactions.html");

	}
	
	@Before
	public void resetPage(){
		
		driver.navigate().refresh();
		
		WebDriverWait warte = new WebDriverWait(driver, 10);
		warte.until(ExpectedConditions.elementToBeClickable(By.id("canvas")));
		warte.until(ExpectedConditions.elementToBeClickable(By.id("keyeventslist")));
		
		driver.findElement(By.tagName("html")).click();
	}
	
	@Test
	public void moveDraggable1ToDroppable1(){
		
		WebElement draggable1 = driver.findElement(By.id("draggable1"));
		WebElement droppable1 = driver.findElement(By.id("droppable1"));
		
		Actions actions = new Actions(driver);
		// TODO was machen hier die Methoden release() und perform...
		actions.clickAndHold(draggable1).moveToElement(droppable1).release().perform();
		
		//.release().perform();
		
		assertEquals("Dropped!", droppable1.getText());
	}
	
	@Test
	public void controlAndSpace(){
		
		WebElement droppable1 = driver.findElement(By.id("droppable1"));
		
		Actions actions = new Actions(driver);
		
		//TODO was macht hier build()?
		actions.click(droppable1).build().perform();
		
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.SPACE).build().perform();
		
		String dropText = droppable1.getText();
		
		actions.keyUp(droppable1, Keys.CONTROL).build().perform();
		
		try{
			assertEquals("Let GO!!", dropText);
			fail("send keys should not be held down long enough to get the text");
		}catch(ComparisonFailure e){
			assertTrue("How can we hold down the keys", true);
			assertEquals("Drop Here", dropText);
		}
		
	}
	
	@Test
	public void controlUndBwaHaHa(){
		
		WebElement draggable1 = driver.findElement(By.id("draggable1"));
		
		Actions actions = new Actions(driver);
		
		// Hier wird durch die Tastatunabkürzung eine Änderung in der Webseite sichtbar gemacht. hier wird 
		//auf Control+b Tastatur gedrückt. Daruch hat sicht in der Webseite eine Komponent sein Text geändert.
		actions.keyDown(Keys.CONTROL).sendKeys("b").keyUp(Keys.CONTROL).perform();
		
		assertEquals("Bwa! Ha! Ha!", draggable1.getText());
	}
	
	
		//Hilfsmethode einige Aktionen können in vielen Testfällen vorkommen, man kann solche Aktionen als Privat Method erstellen uns in den Testfällen abgekürzterweise integrieren.
		private void clickSubmitButton(){
			
			WebElement submitButton;
			submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton'"));
			submitButton.click();
		}
		
		public void clickButton(String adresse){
			
			WebElement submitButton;
			submitButton = driver.findElement(By.cssSelector(adresse));
			submitButton.click();
		}
//		@AfterClass
//		public static void schliessenBrowser(){
//			driver.quit();
//		}

}
