package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.vehicles.Wagon;

import org.junit.Test;

public class WagonTest {
	@Test
	public void testDefaultWagon() {
		Wagon wagon = new Wagon();
		
		assertEquals(wagon.getAxes(), 2);
		assertEquals(wagon.getType(), "people");
		assertEquals(wagon.getCapacity(), 50.0, 0.1);
		assertEquals(wagon.getColour(), "blue");
	}

	@Test
	public void testNonDefaultWagon() {
		Wagon wagon = new Wagon("goods", 45.75, "brown");
		
		assertEquals(wagon.getAxes(), 2);
		assertEquals(wagon.getType(), "goods");
		assertEquals(wagon.getCapacity(), 45.75, 0.01);
		assertEquals(wagon.getColour(), "brown");
	}
}
