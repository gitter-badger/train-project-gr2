package modelrailway.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import modelrailway.helper.Direction;
import modelrailway.railsystem.BaseFork;
import modelrailway.railsystem.CurveRail;
import modelrailway.railsystem.StraightRail;

/**
 * This class tests the functionalities of the class 'BaseFork'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class BaseForkTest {
	@Test
	public void testDefaultBaseFork() {
		BaseFork baseForkLeft = new BaseFork("left");
		BaseFork baseForkRight = new BaseFork("right");
		
		assertEquals(baseForkLeft.getType(),"left");
		assertEquals(baseForkRight.getType(),"right");
		
		assertEquals(baseForkLeft.getConnectionA(),null);
		assertEquals(baseForkLeft.getConnectionB(),null);
		assertEquals(baseForkLeft.getConnectionC(),null);
	}
	
	@Test
	public void testDefaultDimensionsLeft() throws Exception {
		BaseFork baseFork = new BaseFork("left");
		
		assertEquals(baseFork.getAngle(), 30.0, 0.1);
		assertEquals(baseFork.getRadius(), 31.5, 0.1);
		
		assertEquals(baseFork.getLengthStraight(), 15.5, 0.0001);
		assertEquals(baseFork.getLengthCurve(), 16.4933, 0.0001);
		
		baseFork.changeDirection(new Direction("A", "B"));
		assertEquals(baseFork.getLength(), 16.4933, 0.0001);
		
		baseFork.changeDirection(new Direction("A", "C"));
		assertEquals(baseFork.getLength(), 15.5, 0.0001);
	}
	
	@Test
	public void testNonDefaultDimensionsLeft() throws Exception {
		BaseFork baseFork = new BaseFork("left", 40.0, 45.0, 20.5);
		
		assertEquals(baseFork.getAngle(), 45.0, 0.1);
		assertEquals(baseFork.getRadius(), 40.0, 0.1);
		
		assertEquals(baseFork.getLengthStraight(), 20.5, 0.0001);
		assertEquals(baseFork.getLengthCurve(), 31.4159, 0.0001);
		
		baseFork.changeDirection(new Direction("A", "B"));
		assertEquals(baseFork.getLength(), 31.4159, 0.0001);
		
		baseFork.changeDirection(new Direction("A", "C"));
		assertEquals(baseFork.getLength(), 20.5, 0.0001);
	}
	
	@Test
	public void testDefaultDimensionsRight() throws Exception {
		BaseFork baseFork = new BaseFork("right");
		
		assertEquals(baseFork.getAngle(), 30.0, 0.1);
		assertEquals(baseFork.getRadius(), 31.5, 0.1);
		
		assertEquals(baseFork.getLengthStraight(), 15.5, 0.0001);
		assertEquals(baseFork.getLengthCurve(), 16.4933, 0.0001);
		
		baseFork.changeDirection(new Direction("A", "B"));
		assertEquals(baseFork.getLength(), 16.4933, 0.0001);
		
		baseFork.changeDirection(new Direction("A", "C"));
		assertEquals(baseFork.getLength(), 15.5, 0.0001);
	}
	
	@Test
	public void testNonDefaultDimensionsRight() throws Exception {
		BaseFork baseFork = new BaseFork("right", 40.0, 45.0, 20.5);
		
		assertEquals(baseFork.getAngle(), 45.0, 0.1);
		assertEquals(baseFork.getRadius(), 40.0, 0.1);
		
		assertEquals(baseFork.getLengthStraight(), 20.5, 0.0001);
		assertEquals(baseFork.getLengthCurve(), 31.4159, 0.0001);
		
		baseFork.changeDirection(new Direction("A", "B"));
		assertEquals(baseFork.getLength(), 31.4159, 0.0001);
		
		baseFork.changeDirection(new Direction("A", "C"));
		assertEquals(baseFork.getLength(), 20.5, 0.0001);
	}

	@Test
	public void testConnect() throws Exception {

		BaseFork baseFork = new BaseFork("left");
		
		StraightRail straightRail1 = new StraightRail();
		StraightRail straightRail2 = new StraightRail();
		StraightRail straightRail3 = new StraightRail();
		
		baseFork.connect(straightRail1);
		baseFork.connect(straightRail2);
		baseFork.connect(straightRail3);
		
		assertEquals(baseFork.getConnectionA(),straightRail1);
		assertEquals(baseFork.getConnectionB(),straightRail2);
		assertEquals(baseFork.getConnectionC(),straightRail3);
		
		try {
			baseFork.connect(new StraightRail(7.5));
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "This forks connections are already used. You can't change these connections.";
			assertEquals(e.getMessage(), message);
		}
	}
	
	

	@Test
	public void testChangeDirections() throws Exception {
		BaseFork baseFork = new BaseFork("left");
		List<Direction> directions = new ArrayList<Direction>();
		
		directions.add(new Direction("A", "B"));
		directions.add(new Direction("A", "C"));

		assertEquals(baseFork.getPossibleDirections().get(0).getStringified(), directions.get(0).getStringified());
		assertEquals(baseFork.getPossibleDirections().get(0).getStringifiedReverse(), directions.get(0).getStringifiedReverse());
		assertEquals(baseFork.getPossibleDirections().get(1).getStringified(), directions.get(1).getStringified());
		assertEquals(baseFork.getPossibleDirections().get(1).getStringifiedReverse(), directions.get(1).getStringifiedReverse());
				
		assertEquals(baseFork.getCurrentDirection().getStringified(), new Direction("A", "B").getStringified());
		assertEquals(baseFork.getCurrentDirection().getStringifiedReverse(), new Direction("B", "A").getStringified());	
		
		baseFork.changeDirection(new Direction("A","C"));
		assertEquals(baseFork.getCurrentDirection().getStringified(), new Direction("A","C").getStringified());
		assertEquals(baseFork.getCurrentDirection().getStringifiedReverse(), new Direction("C","A").getStringified());
		
		try {
			baseFork.changeDirection(new Direction("C","D"));
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "It's impossible to set this direction, please try another one.";
			assertEquals(e.getMessage(), message);
		}
	}
	

	@Test
	public void testUnderMinimum() {
		try {
			BaseFork fork = new BaseFork("left", -25.5, -15.3, -15.5);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals("invalid argument", e.getMessage());
		}
		
	}
	
	@Test
	public void testMinimumValue() {
		try {
			BaseFork fork = new BaseFork("left", 0, 0, 0);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals("invalid argument", e.getMessage());
		}
		
	}
	
	@Test
	public void testValidValue() throws Exception {
		BaseFork fork = null;
		try {
			fork = new BaseFork("left", 35.0, 30.0, 45.0);
		}
		finally {
			assertEquals(fork.getAngle(),30.0,0.1);
			assertEquals(fork.getRadius(),35.0,0.1);
			assertEquals(fork.getLengthStraight(),45.0,0.1);
		}		
	}
	
	@Test
	public void testMaximumValue() throws Exception {
		BaseFork fork = null;
		try {
			fork = new BaseFork("left", 50, 360, 50);
		}
		finally {
			assertEquals(fork.getAngle(),360.0,0.1);
			assertEquals(fork.getRadius(),50.0,0.1);
			assertEquals(fork.getLengthStraight(),50.0,0.1);
		}
	}
	
	@Test
	public void testOverMaximum() {
		try {
			BaseFork fork = new BaseFork("left", 75.3, 365.0, 52.7);
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(), "invalid argument");
		}		
	}	
}
