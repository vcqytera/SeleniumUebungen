import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ErsteFindByUebung {

	static WebDriver driver;
	
	@BeforeClass
	public static void createDriverAndVisitTestPage(){
		
		driver.navigate().to("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
		
	}
	
	
	
	public void findByID(){
		
		WebElement cParagraph = driver.findElement(By.id("p3"));
		
	}
	
}
