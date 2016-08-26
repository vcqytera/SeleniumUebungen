import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class JUnitBeforeUndAfter {

	@BeforeClass
	public static void beforeTestClass() {
		System.out.println("Szenario vorbereiten: BeforeClass.");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("Testfall vorbreiten: Before");
	}
	
	@Test
	public void Testfall1() {
		System.out.println("Das ist Testfall 1!");
	}
	
	@Test
	public void Testfall2() {
		System.out.println("Das ist Testfall 2!");
	}
	
	@Test
	public void Testfall3() {
		System.out.println("Das ist Testfall 3!");
	}
	
	@Ignore
	public void TestfallIgnor() {
		System.out.println("Das ist Testfall Ignor!");
	}
	
	@After
	public void afterTest() {
		System.out.println("Testfall nachbereiten: After");
	}
	
	@AfterClass
	public static void afterTestClass() {
		System.out.println("Szenario nachbreiten: AfterClass");
	}
}
