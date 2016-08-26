import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class NavigationBasicsTest {
	
	static WebDriver driver;
	final private String PROTOCOL = "http";
	final private String DOMAIN = "www.compendiumdev.co.uk";
	final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;
	
	@BeforeClass
	public static void createDriver(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void navigateWithGet(){
		driver.get(ROOT_URL + "/selenium");
		
		assertTrue(driver.getTitle().startsWith("Selenium Simplified"));
	}
	
	@Test
	public void navigateWithNavigateTo(){
		driver.navigate().to(ROOT_URL + "/selenium/search.php");
		
		assertTrue(driver.getTitle().startsWith("Selenium Simplified Search Engine"));
	}
	
	@Test
	public void navigateWithNavigateToURL() throws MalformedURLException {
		URL searchPage = new URL (PROTOCOL, DOMAIN, "/selenium/search.php");
		
		driver.navigate().to(searchPage);
	}
	
	@Test
	public void navigateWithNavigateBackAndForward(){
		driver.navigate().to(ROOT_URL + "/selenium/basic_html_form.html");
		assertTrue(driver.getTitle().startsWith("HTML Form Elements"));
		
		driver.navigate().to(ROOT_URL + "/selenium/basic_web_page.html");
		assertTrue(driver.getTitle().startsWith("Basic Web Page Title"));
		
		driver.navigate().back();
		assertTrue(driver.getTitle().startsWith("HTML Form Elements"));
		
		driver.navigate().forward();
		assertTrue(driver.getTitle().startsWith("Basic Web Page Title"));
	}
	
	@Test
	public void navigateWithRefresh(){
		driver.navigate().to(ROOT_URL + "/selenium/refresh.php");
		
		final String refreshTitleConstant = "Refreshed Page on";
		
		assertTrue(driver.getTitle().startsWith(refreshTitleConstant));
		
		long startTime = Long.parseLong(driver.getTitle().replaceFirst(refreshTitleConstant, ""));
		
		try {
			Thread.sleep(2000);
			}
		catch (InterruptedException e){
			//ignore interrupt
		}
		
		driver.navigate().refresh();
		
		assertTrue(driver.getTitle().startsWith(refreshTitleConstant));
		
		long endTime = Long.parseLong(driver.getTitle().replaceFirst(refreshTitleConstant, ""));
		
		assertTrue("expected"+ endTime + " > " + startTime, endTime > startTime);
				
		
	}
	
	@AfterClass
	public static void schliessDriver(){
		
		driver.quit();
	}
	
	
}
