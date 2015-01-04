package modelrailway.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import modelrailway.helper.Direction;
import modelrailway.railsystem.BaseFork;
import modelrailway.railsystem.StraightRail;
import modelrailway.railsystem.TrippleFork;

import org.junit.Test;


public class TrippleForkTest {
	@Test
	public void testDefaultTrippleFork() {
		TrippleFork trippleFork = new TrippleFork();
		
		assertEquals(trippleFork.getType(), "tripple");

		assertEquals(trippleFork.getConnectionA(),null);
		assertEquals(trippleFork.getConnectionB(),null);
		assertEquals(trippleFork.getConnectionC(),null);
		assertEquals(trippleFork.getConnectionD(),null);
	}
	
	@Test
	public void testDefaultDimensionsTrippleFork() {
		TrippleFork trippleFork = new TrippleFork();
		
		assertEquals(trippleFork.getRadius(), 31.5, 0.1);
		assertEquals(trippleFork.getAngle(), 30.0, 0.1);
		assertEquals(trippleFork.getLengthCurve(), 16.4933, 0.0001);
		assertEquals(trippleFork.getLengthStraight(), 15.5, 0.1);
	}
	
	@Test
	public void testNonDefaultDimensionsTrippleFork() {
		TrippleFork trippleFork = new TrippleFork(41.5,45.0,50);

		assertEquals(trippleFork.getRadius(), 41.5, 0.1);
		assertEquals(trippleFork.getAngle(), 45.0, 0.1);
		assertEquals(trippleFork.getLengthCurve(), 32.5940, 0.0001);
		assertEquals(trippleFork.getLengthStraight(), 50.0, 0.1);		
	}
	
	@Test
	public void testConnect() throws Exception {
		StraightRail straightRail1 = new StraightRail(10);
		StraightRail straightRail2 = new StraightRail(10);
		StraightRail straightRail3 = new StraightRail(10);
		StraightRail straightRail4 = new StraightRail(10);
		
		TrippleFork trippleFork = new TrippleFork();
		
		trippleFork.connect(straightRail1);
		trippleFork.connect(straightRail2);
		trippleFork.connect(straightRail3);
		trippleFork.connect(straightRail4);
		
		assertEquals(trippleFork.getConnectionA(), straightRail1);
		assertEquals(trippleFork.getConnectionB(), straightRail2);
		assertEquals(trippleFork.getConnectionC(), straightRail3);
		assertEquals(trippleFork.getConnectionD(), straightRail4);
		
		try {
			trippleFork.connect(new StraightRail(7.5));
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "This forks connections are already used. You can't change these connections.";
			assertEquals(e.getMessage(), message);
		}
	}
	
	@Test
	public void testChangeDirections() throws Exception {
		TrippleFork trippleFork = new TrippleFork();
		
		List<Direction> directions = new ArrayList<Direction>();
		
		directions.add(new Direction("A", "B"));
		directions.add(new Direction("A", "C"));
		directions.add(new Direction("A", "D"));

		assertEquals(trippleFork.getPossibleDirections().get(0).getStringified(), directions.get(0).getStringified());
		assertEquals(trippleFork.getPossibleDirections().get(0).getStringifiedReverse(), directions.get(0).getStringifiedReverse());
		assertEquals(trippleFork.getPossibleDirections().get(1).getStringified(), directions.get(1).getStringified());
		assertEquals(trippleFork.getPossibleDirections().get(1).getStringifiedReverse(), directions.get(1).getStringifiedReverse());
		assertEquals(trippleFork.getPossibleDirections().get(2).getStringified(), directions.get(2).getStringified());
		assertEquals(trippleFork.getPossibleDirections().get(2).getStringifiedReverse(), directions.get(2).getStringifiedReverse());
				
		assertEquals(trippleFork.getCurrentDirection().getStringified(), new Direction("A", "B").getStringified());
		assertEquals(trippleFork.getCurrentDirection().getStringifiedReverse(), new Direction("B", "A").getStringified());	
		
		trippleFork.changeDirection(new Direction("A","C"));
		assertEquals(trippleFork.getCurrentDirection().getStringified(), new Direction("A","C").getStringified());
		assertEquals(trippleFork.getCurrentDirection().getStringifiedReverse(), new Direction("C","A").getStringified());
		
		trippleFork.changeDirection(new Direction("A","D"));
		assertEquals(trippleFork.getCurrentDirection().getStringified(), new Direction("A","D").getStringified());
		assertEquals(trippleFork.getCurrentDirection().getStringifiedReverse(), new Direction("D","A").getStringified());
		
		try {
			trippleFork.changeDirection(new Direction("C","D"));
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "It's impossible to set this direction, please try another one.";
			assertEquals(e.getMessage(), message);
		}
	}
}
