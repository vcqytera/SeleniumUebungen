
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class WindowsExampleTest {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void BrowserAufrufen() {
		
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.compendiumdev.co.uk/selenium/frames");

	}
	
 @Test
 public void switchToNewWindow(){
	 	 
 // Current bug open with chrome driver
 // http://code.google.com/p/chromedriver/issues/detail?id=107

	
 
 
 //String framesWindowHandle = driver.getWindowHandles();
 assertEquals("Expected only 1 current window", 1, driver.getWindowHandles().size());
 driver.switchTo().frame("content");
 driver.findElement(By.cssSelector("a[href='http://www.seleniumsimplified.com']")).click();
 assertEquals("Expected a New Window opened", 2, driver.getWindowHandles().size());
 Set<String> myWindows = driver.getWindowHandles();
 String newWindowHandle="";
 for(String aHandle : myWindows){
 if(!framesWindowHandle.contentEquals(aHandle)){
 newWindowHandle = aHandle; break;
 }
 }
 driver.switchTo().window(newWindowHandle);
 assertTrue("Expected Selenium Simplified site",
 driver.getTitle().contains("Selenium Simplified"));
 }
 
 @Test
 public void WindowsManageExampleTest(){
	 
	 driver.manage().window().setPosition(new Point(10,20));
	 Point pos = driver.manage().window().getPosition();
	 
	 assertEquals(10, pos.getX());
	 assertEquals(20, pos.getY());
	 
	 driver.manage().window().setSize(new Dimension(350,400));
	 Dimension winSizes = driver.manage().window().getSize();
	 
	 assertEquals(350, winSizes.getWidth());
	 assertEquals(400, winSizes.getHeight());
	 
 }
}