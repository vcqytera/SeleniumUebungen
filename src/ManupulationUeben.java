import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.jetty.html.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ManupulationUeben {
	
	static WebDriver driver;

	@BeforeClass
	public static void erstelleDriverUndBesucheTestseite() {

		driver = new FirefoxDriver();
		driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

	}
	
	@Before
	public void vorJedemTestAufDieSeiteNavigieren() {

		driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

	}
	
	@Test
	public void checkBoxSelektieren(){
		
		WebElement checkBox1;
		
		checkBox1 = driver.findElement(By.xpath(".//*[@value='cb1']"));
		
		assertFalse("Starts not selects", checkBox1.isSelected());
				
		checkBox1.click();
		
		assertTrue("Click selects", checkBox1.isSelected());
	}
	
	@Test
	public void submitFormWithButtonClick(){
		
		WebElement submitButton;
		
		submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton']"));
		
		submitButton.click();
		
		assertEquals ("Expected the form to be processed", driver.getTitle(), "Processed Form Details");
						
	}
	
	@Test
	public void submitButtonWithKeyPress(){
		
		WebElement submitButton2;
		
		submitButton2 = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton']"));
		
		submitButton2.sendKeys(Keys.SPACE);
		
		assertEquals("Expected the from to be processed", driver.getTitle(), "Processed Form Details");
				
	}
	
	@Test
	public void submitFormWithFormSubmit(){
		
		WebElement submitForm;
		submitForm = driver.findElement(By.id("HTMLFormElement"));
		
		submitForm.submit();
		
		assertEquals("Expected the form to be processed", driver.getTitle(), "Processed Form Details");
		
	}
	
	@Test
	public void submitFormDefaultComments(){
		
		WebElement submitButton;
		
		submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton"));
		
		submitButton.click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));
		
		WebElement commentsResults;
		commentsResults = driver.findElement(By.id("_valuecomments"));
		//Überprüft wird hier, was in der Kommentarfeld default geschrieben ist.
		assertEquals("Expected default comment", "Comments...", commentsResults.getText());
		
	}
	
	@Test
	public void submitFormWithMyComments(){
		
		WebElement submitButton;
		WebElement commentTestArea;
		
		String myCommentString = "Das ist mein Kommentar!!!";
		commentTestArea = driver.findElement(By.name("comments"));
		commentTestArea.clear();
		commentTestArea.sendKeys(myCommentString);
		
		submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton'"));
		submitButton.click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));
		
		WebElement commentsResults;
		
		commentsResults = driver.findElement(By.id("'-valuecomments"));
		assertEquals("Expected default comments", myCommentString, commentsResults.getText());
		
	}
	
	@Test
	public void submitFormWithOnlyRadioButton2SelectedFindElementException(){
		WebElement radioButton2;
		
		radioButton2 = driver.findElement(By.cssSelector("input[value='rd2'"));
		
		//Es ist wichtig, dass die Radiobutton vorher nicht selektiert ist.
		if (!radioButton2.isSelected()){
			
			radioButton2.click();
		}
		
		
		WebElement submitButton;
		submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton'"));
		submitButton.click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));
		
		WebElement radioButtonResult;
		
		radioButtonResult = driver.findElement(By.id("_valueradioval"));
		
		assertEquals("Expected to radio button 2", radioButtonResult.getText(), "rd2");
		
		
	}
	
	@Test
	public void DropdownElementAuswahl(){
		
		WebElement dropDownSelect;
		WebElement dropDownOption;
		
		dropDownSelect = driver.findElement(By.cssSelector("select[name='dropdown]"));
		dropDownOption = dropDownSelect.findElement(By.cssSelector("option[value='dd5'"));
		dropDownOption.click();
		
		//clickSubmitButton();
		clickButton("input[type='submit'][name='submitbutton'");
		
		new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));
		
		//assertDropdownValueIsCorrect();
	}
	
	@Test
	public void MultiSelectUebung(){
		
		WebElement multiSelect;
		WebElement dropDownOption;
		
		multiSelect = driver.findElement(By.cssSelector("select[multiple='multible']"));
		
		// TODO: Ich muss hier eine Multiselect durchführen können. 
		// Obwohl ich die nötige IMport habe, kann ich hier eine Liste von WebElemente erstellen.
		
		java.util.List<WebElement> multiSelectOptions;
		multiSelectOptions = (java.util.List<WebElement>) multiSelect.findElement(By.tagName("option"));
		
		multiSelectOptions.get(0).click();
		multiSelectOptions.get(1).click();
		multiSelectOptions.get(2).click();
		
		if(multiSelectOptions.get(3).isSelected()){
			multiSelectOptions.get(3).click();
		}
		
	}
	
	@Test
	public void DateiHochLaden() throws URISyntaxException{
		
		WebElement filenameInput;
		
		filenameInput = driver.findElement(By.cssSelector("input[type='file']"));
		//filenameInput.click();
		
		// TODO : Nach dem die Dialogfenster für die Auswahl geöffnet wurde, sollte das Fenster die Datei auswählen und wieder geschlossen werden. 
		File testFile = new File("C:/Development/webDriverExperiments-master/webDriverExperiments-master/resource/testTextFile.txt");
				
		//testFile.getClass().getResource("C:/Development/webDriverExperiments-master/webDriverExperiments-master/resource/testTextFile.txt").toURI();
		//testFile.canExecute();
		
		filenameInput.sendKeys(testFile.getAbsolutePath());
		
		// TODO: Möchte hier in dieser Stelle ein Screenshot erstellen.
		
		//Wait for 4 Seconds to see Today's date selected.
		try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
		clickSubmitButton();
	}
	
	@Test
	public void kannIchEinCheckboxLoeschen() {
		
		WebElement ceckBox1;
		
		ceckBox1 = driver.findElement(By.cssSelector("input[value='cb1']"));
		
		try{
			ceckBox1.clear();
			fail("Expected an exception as you can't clear a checkbox");
		}catch(WebDriverException e){
			
		}
	}
	
	@Test
	public void selectSupportExplore(){
		
		WebElement multipleSelectElement;
		
		multipleSelectElement = driver.findElement(By.className("select[multible='multible']"));
		
		//TODO Select Objekt erstellen. Video 98 anschauen!!!
//		Select multipleSelect = new Select(multipleSelectElement, true);
//		assertTrue(multipleSelect.isMultiple);
	}
	
	@Test
	public void userInteraktionUeben(){
		
		
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
	@AfterClass
	public static void schliessenBrowser(){
		driver.quit();
	}

}
