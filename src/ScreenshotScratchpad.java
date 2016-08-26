import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class ScreenshotScratchpad {
	
	@Test
	public void gotoPage() throws IOException{
		//Browser öffnen
		WebDriver driver = new FirefoxDriver();
		//Seite aufgerufen
		driver.get("http://seleniumsimplified.com");
		//ScreenShot machen
		TakesScreenshot snapper = (TakesScreenshot)driver;
		//Screenshot als Datei erstellen
		File tempScreenshot = snapper.getScreenshotAs(OutputType.FILE);
		//Temporäre Pfad des angelegten Screenshot in der Konsole angeben
		System.out.println(tempScreenshot.getAbsolutePath());
		//Ordner anlegen
		File myScreenshotDirectory = new File("C:\\temp\\screenshots\\");
		myScreenshotDirectory.mkdir();
		//Datei in dem Ordner mit dem angegebenen Name speichern
		File myScreenshot = new File(myScreenshotDirectory, "gotoPageScreen.png");
		FileUtils.moveFile(tempScreenshot, myScreenshot);
		//Datei in der Browser anzeigen
		driver.get("file://"+myScreenshot.getAbsolutePath());
		
	}

}
