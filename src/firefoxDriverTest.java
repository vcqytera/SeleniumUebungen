import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class firefoxDriverTest {

private static WebDriver browser;

@BeforeClass
public static void aufrufenBrowser()
{
	browser = new FirefoxDriver();
}

@Test
public void navigiereMitNavigateTo(){
	browser.navigate().to("http://www.qytera.de/");
	assertTrue(browser.getTitle().startsWith("Qytera | Testmanagement,Testautomatisierung,ISTQB Certified Tester"));
}

@AfterClass
public static void schliessenBrowser(){
	browser.quit();
	System.out.println("Test ist abgeschlossen!");
}

}
