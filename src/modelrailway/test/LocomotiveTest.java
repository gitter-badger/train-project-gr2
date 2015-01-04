package modelrailway.test;

import static org.junit.Assert.*;
import modelrailway.vehicles.Locomotive;

import org.junit.Test;

public class LocomotiveTest {

	@Test
	public void testDefaultLocomotive() {
		Locomotive locomotive = new Locomotive();
		
		assertEquals(locomotive.getType(), "electricity");
		assertEquals(locomotive.getPower(), 10);
		assertEquals(locomotive.getAxes(), 2);
	}
	
	@Test
	public void testNonDefaultLocomotive() {
		Locomotive locomotive = new Locomotive("fuel", 15);
		
		assertEquals(locomotive.getType(), "fuel");
		assertEquals(locomotive.getPower(), 15);
		assertEquals(locomotive.getAxes(), 2);
	}

	@Test
	public void testNonDefaultLocomotive2() {
		Locomotive locomotive = new Locomotive("fuel", 20, 4);
		
		assertEquals(locomotive.getType(), "fuel");
		assertEquals(locomotive.getPower(), 20);
		assertEquals(locomotive.getAxes(), 4);
	}
}
