package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.vehicles.TrainPart;

import org.junit.Test;

/**
 * This class tests the functionalities of the class 'TrainPart'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class TrainPartTest {
	@Test
	public void testDefaultTrainPart() {
		TrainPart trainPart = new TrainPart("goods");
		
		assertEquals(trainPart.getAxes(), 2);
		assertEquals(trainPart.getType(), "goods");
	}

	@Test
	public void testNonDefaultTrainPart() {
		TrainPart trainPart = new TrainPart("fuel", 4);
		
		assertEquals(trainPart.getAxes(), 4);
		assertEquals(trainPart.getType(), "fuel");
	}
}
