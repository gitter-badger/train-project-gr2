package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.railsystem.BaseRail;
import modelrailway.railsystem.RailwayCrossingStreet;
import modelrailway.railsystem.StraightRail;

import org.junit.Test;

/**
 * This class doesn't test the functionalities of the class 'StraightRail', becuase this only owns some constructors and getters.
 * This class tests the value range inherited from BaseRail.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class StraightRailTest {
	@Test
	public void testUnderMinimum() {
		try {
			StraightRail rail = new StraightRail(-5.0);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals("invalid argument", e.getMessage());
		}
		
	}
	
	@Test
	public void testMinimumValue() {
		try {
			StraightRail rail = new StraightRail(0);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals("invalid argument", e.getMessage());
		}
		
	}
	
	@Test
	public void testValidValue() {
		StraightRail rail = null;
		try {
			rail = new StraightRail(12.0);
		}
		finally {
			assertEquals(rail.getLength(),12.0,0.1);
		}		
	}
	
	@Test
	public void testMaximumValue() {
		StraightRail rail = null;
		try {
			rail = new StraightRail(50.0);
		}
		finally {
			assertEquals(rail.getLength(),50.0,0.1);
		}	
	}
	
	@Test
	public void testOverMaximum() {
		try {
			StraightRail rail = new StraightRail(50.1);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals("invalid argument", e.getMessage());
		}
		
	}
}
