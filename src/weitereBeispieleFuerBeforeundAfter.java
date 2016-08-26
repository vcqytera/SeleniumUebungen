import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class weitereBeispieleFuerBeforeundAfter {
private String iSetThisBefore = "set as feild";
private static String iSetThisBeforeClass = "default";

@BeforeClass
public static void setSomethingBeforeClass(){
	iSetThisBeforeClass = "for all class method";
}

@Test
public void usingAssertTrue(){
	assertTrue("true is true", true);
	
	assertTrue("i know what 3+3 is", (3+3) == 6);
	String theAnswer = "The Answer";
	assertTrue("The answer is true", "the answer".equalsIgnoreCase(theAnswer));
}

@Test
public void usingAssertFalse(){
	assertFalse ("false is not true", !true);
	assertFalse ("I always forget half of seven", (7/2) == 4);
	
	String anAnswer = "An Answer";
	assertFalse ("An Answer does not contain The Answer", anAnswer.contains("The"));
}

@Test
public void usingAssertEquals(){
	assertEquals ("true == true", true, true);
	
	String myAnswer = "My Answer";
	assertEquals ("String compare", "My Answerxy", myAnswer);
	
	assertEquals ("3+3", 6, 3+3);
	
}

@Before
public void setSomethingBeforeToUseLater(){
	iSetThisBefore = "set before";
}

@Test
public void checkISetSomethingbefore(){
	assertFalse("iSetThisBefore should not equal default value", "set as field".equals(iSetThisBefore));
	
	assertEquals("iSetThisBefore Should have changed", "set before", iSetThisBefore);
	
}

}