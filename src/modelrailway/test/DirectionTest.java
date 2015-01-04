package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.helper.Direction;

import org.junit.Test;

/**
 * This class tests the functionalities of the class 'Direction'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class DirectionTest {
	@Test
	public void testDirection() {
		Direction direction = new Direction("A", "B");
		
		assertEquals(direction.getStringified(),"A>B");
		assertEquals(direction.getStringifiedReverse(),"B>A");
	}
}
