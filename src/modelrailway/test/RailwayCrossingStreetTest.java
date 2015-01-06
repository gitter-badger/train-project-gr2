package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.railsystem.RailwayCrossingStreet;

import org.junit.Test;

/**
 * This class tests the functionalities of the class 'RailWayCrossingStreet'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class RailwayCrossingStreetTest {

	@Test
	public void testClose() {
		RailwayCrossingStreet street = new RailwayCrossingStreet(5.0,true,true,true);
		street.close();
		assertTrue(street.areBarriersActive());
		assertTrue(street.areTrafficLightsActive());
		assertTrue(street.areWarnSignsActive());
	}

	@Test
	public void testOpen() {
		RailwayCrossingStreet street = new RailwayCrossingStreet(5.0,true,true,true);
		street.open();
		assertFalse(street.areBarriersActive());
		assertFalse(street.areTrafficLightsActive());
		assertFalse(street.areWarnSignsActive());
	}

}
