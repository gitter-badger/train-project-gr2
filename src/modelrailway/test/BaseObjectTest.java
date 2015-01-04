package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.BaseObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the functionalities of the class 'BaseObject'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class BaseObjectTest {
	BaseObject baseObject;
	
	@Before
	public void testInit() {
		baseObject = new BaseObject();		
	}

	@Test
	public void testId() {
		assertNotNull(baseObject.getId());
	}
	
	@After
	public void testFinish() {
		System.out.println("BaseObjectTests finished");
	}
}