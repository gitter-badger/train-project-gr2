package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.railsystem.BufferStop;
import modelrailway.railsystem.StraightRail;

import org.junit.Test;

/**
 * This class tests the functionalities of the class 'BufferStop'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class BufferStopTest {

	@Test
	public void testDefaultBufferStop() {
		BufferStop bufferStop = new BufferStop();

		assertEquals(bufferStop.getLength(), 2.0, 0.1);
		assertEquals(bufferStop.getType(), "holz");
	}
	
	@Test
	public void testConnect() throws Exception {
		BufferStop bufferStop = new BufferStop();
		StraightRail straightRail = new StraightRail();
		
		bufferStop.connect(straightRail);
		assertEquals(bufferStop.getConnectionA().getId(),straightRail.getId());
		
		try{
			bufferStop.connect(new StraightRail());
            fail("Expected an exception to be thrown.");
		}
		catch(Exception e) {
			String message = "This rails connection is already used. You cant change this connection.";
			assertEquals(e.getMessage(), message);
		}
	}
	
	@Test
	public void testNonDefaultBufferStop() {
		BufferStop bufferStop = new BufferStop(4.75,"Eisen");

		assertEquals(bufferStop.getLength(), 4.75, 0.1);
		assertEquals(bufferStop.getType(), "eisen");
	}
}