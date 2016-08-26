import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DBFahrplanEingaben {

	static WebDriver driver;

	@BeforeClass
	public static void erstelleDriverUndBesucheTestseite() {

		driver = new FirefoxDriver();
		driver.navigate().to("https://www.bahn.de/p/view/index.shtml");

	}
	
	@Test
	public void FahrzielAngeben(){
		
		WebElement Fahrzielvon;
		WebElement Fahrzielnach;
		WebElement SuchButton;
		WebElement Fahrt;
		
		String Startort = "Frankfurt";
		String Zielort = "Giessen";
		
		Fahrzielvon = driver.findElement(By.cssSelector("input[type='text'][name='S']"));
		Fahrzielnach =  driver.findElement(By.cssSelector("input[type='text'][name='Z']"));
		SuchButton = driver.findElement(By.cssSelector("input[type='submit'][value='Suchen']"));
		
		Fahrzielvon.clear();
		Fahrzielnach.clear();
		
		Fahrzielvon.sendKeys(Startort);
		Fahrzielnach.sendKeys(Zielort);
		
		SuchButton.click();
		
		//Warten
		new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("DB BAHN - Verbindungen - Ihre Auskunft"));
		Fahrt = driver.findElement(By.cssSelector(".connection"));
		
		assertEquals("Erwartet das Ergebnis", "FRANKFURT(MAIN) Gießen", Fahrt.getText());
	}
	
	@AfterClass
	public static void schliessenBrowser(){
		driver.quit();
	}
}
