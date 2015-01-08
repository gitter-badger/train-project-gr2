package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.railsystem.CurveRail;
import modelrailway.railsystem.StraightRail;

import org.junit.Test;

/**
 * This class tests the functionalities of the class 'CurveRail'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class CurveRailTest {
	@Test
	public void testDefaultCurveRail() {
		CurveRail curveRail = new CurveRail();
		
		assertEquals(curveRail.getAngle(), 30.0, 0.1);
		assertEquals(curveRail.getRadius(), 31.5, 0.1);
		assertEquals(curveRail.getLength(), 16.4933 ,0.0001);
		
		assertEquals(curveRail.getConnectionA(),null);
		assertEquals(curveRail.getConnectionB(),null);
	}
	
	@Test
	public void testNonDefaultCurveRail() {
		CurveRail curveRail = new CurveRail(45.0,41.5);
		
		assertEquals(curveRail.getAngle(), 45.0, 0.1);
		assertEquals(curveRail.getRadius(), 41.5, 0.1);
		assertEquals(curveRail.getLength(), 32.5940 ,0.0001);
	}
	
	@Test
	public void testConnect() throws Exception {
		CurveRail curveRail = new CurveRail();
		 
		StraightRail straightRail1 = new StraightRail();
		StraightRail straightRail2 = new StraightRail();
		
		curveRail.connect(straightRail1);
		curveRail.connect(straightRail2);
		
		assertEquals(curveRail.getConnectionA(),straightRail1);
		assertEquals(curveRail.getConnectionB(),straightRail2);
		
		try {
			curveRail.connect(new StraightRail(7.5));
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "This forks connections are already used. You can't change these connections.";
			assertEquals(e.getMessage(), message);
		}
	}
	

	@Test
	public void testUnderMinimum() {
		try {
			CurveRail rail = new CurveRail(-25, -15);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals("invalid argument", e.getMessage());
		}
		
	}
	
	@Test
	public void testMinimumValue() {
		try {
			CurveRail rail = new CurveRail(0, 0);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals("invalid argument", e.getMessage());
		}
		
	}
	
	@Test
	public void testValidValue() {
		CurveRail rail = null;
		try {
			rail = new CurveRail(30, 35);
		}
		finally {
			assertEquals(rail.getAngle(),30.0,0.1);
			assertEquals(rail.getRadius(),35.0,0.1);
		}		
	}
	
	@Test
	public void testMaximumValue() {
		try {
			CurveRail rail = new CurveRail(360, 50);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(), "invalid argument");
		}
	}
	
	@Test
	public void testOverMaximum() {
		try {
			CurveRail rail = new CurveRail(361, 52);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(), "invalid argument");
		}		
	}	
}
