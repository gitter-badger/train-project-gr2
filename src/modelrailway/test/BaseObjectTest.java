package modelrailway.test;

import static org.junit.Assert.*;

import modelrailway.BaseObject;

import org.junit.Test;

/**
 * This class tests the functionalities of the class 'BaseObject'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class BaseObjectTest {
	@Test
	public void testId() {
		BaseObject baseObject = new BaseObject();
		assertNotNull(baseObject.getId());
	}
}