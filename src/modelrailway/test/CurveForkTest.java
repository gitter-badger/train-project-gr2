package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.railsystem.BaseFork;
import modelrailway.railsystem.CurveFork;

import org.junit.Test;

/**
 * This class tests the functionalities of the class 'CurveFork'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class CurveForkTest {
	@Test
	public void testDefaultCurveForks() {
		CurveFork curveForkLeft = new CurveFork("left");
		CurveFork curveForkRight = new CurveFork("right");
		
		assertEquals(curveForkLeft.getType(), "left");
		assertEquals(curveForkRight.getType(), "right");
	}

	@Test
	public void testDefaultDimensions() throws Exception {
		CurveFork curveFork = new CurveFork("left");		
		
		assertEquals(curveFork.getAngle(), 30.0, 0.1);
		assertEquals(curveFork.getAngleBig(), 30.0, 0.1);
		
		assertEquals(curveFork.getRadius(), 31.5, 0.1);
		assertEquals(curveFork.getRadiusBig(), 35.3, 0.1);		
		
		assertEquals(curveFork.getLengthBig(), 18.4830, 0.0001);
		assertEquals(curveFork.getLengthSmall(), 16.4933, 0.0001);
		
		try {
			curveFork.getLengthCurve();
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "This method is not available on this class.";
			assertEquals(e.getMessage(), message);
		}
		
		try {
			curveFork.getLengthStraight();
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "This method is not available on this class.";
			assertEquals(e.getMessage(), message);
		}
	}
	
	@Test
	public void testNonDefaultDimension() throws Exception {
		CurveFork curveFork = new CurveFork("left",45.0,32.0,45.0,36.5);
		
		assertEquals(curveFork.getAngle(), 45.0, 0.1);
		assertEquals(curveFork.getAngleBig(), 45.0, 0.1);
		
		assertEquals(curveFork.getRadius(), 32.0, 0.1);
		assertEquals(curveFork.getRadiusBig(), 36.5, 0.1);		
		
		assertEquals(curveFork.getLengthBig(), 28.6670, 0.0001);
		assertEquals(curveFork.getLengthSmall(), 25.1327, 0.0001);
		
		try {
			curveFork.getLengthCurve();
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "This method is not available on this class.";
			assertEquals(e.getMessage(), message);
		}
		
		try {
			curveFork.getLengthStraight();
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "This method is not available on this class.";
			assertEquals(e.getMessage(), message);
		}
	}

	@Test
	public void testAnglesAndRadiusses() {		
		try {
			CurveFork curveFork = new CurveFork("left",45.0,32.0,42.0,30.5);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(), "The outter radius has to be bigger then the inner radius.");
		}		
	}
}