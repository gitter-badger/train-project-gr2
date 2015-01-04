package modelrailway.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import modelrailway.railsystem.RailRoad;
import modelrailway.railsystem.StraightRail;
import modelrailway.vehicles.Locomotive;
import modelrailway.vehicles.Train;
import modelrailway.vehicles.Wagon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class tests the functionalities of the class 'Train'.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class TrainTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
	@Test
	public void testDefaultTrain() throws Exception {
		Locomotive locomotive = new Locomotive("fuel", 15);
		Wagon wagon = new Wagon("goods", 45.8, "brown");

		Train train = new Train(locomotive);
		assertEquals(train.getLocomotives().get(0), locomotive);
		
		train.addWagon(wagon);
		assertEquals(train.getWagons().get(0), wagon);
		
		assertEquals(train.getPower(), 15);
		
		RailRoad railRoad = new RailRoad(new StraightRail(10.1), new StraightRail(10.1));
		assertEquals(train.move(railRoad), 0);
	}
	
	@Test
	public void testNonDefaultTrain() throws Exception {
		Locomotive locomotive1 = new Locomotive("fuel", 2);
		Locomotive locomotive2 = new Locomotive("fuel", 2);		
		
		List<Locomotive> locomotives = new ArrayList<Locomotive>();
		
		locomotives.add(locomotive1);
		locomotives.add(locomotive2);
		
		Wagon wagon1 = new Wagon("people", 40, "blue");
		Wagon wagon2 = new Wagon("people", 40, "red");
		Wagon wagon3 = new Wagon("people", 40, "green");
		Wagon wagon4 = new Wagon("people", 40, "yellow");
		Wagon wagon5 = new Wagon("people", 40, "black");
		
		List<Wagon> wagons = new ArrayList<Wagon>();
		
		wagons.add(wagon1);
		wagons.add(wagon2);
		wagons.add(wagon3);
		wagons.add(wagon4);
		wagons.add(wagon5);
		
		Train train = new Train(locomotives, wagons);

		assertEquals(train.getLocomotives().size(), 2);
		assertEquals(train.getLocomotives().get(0), locomotive1);
		assertEquals(train.getLocomotives().get(1), locomotive2);
		
		assertEquals(train.getWagons().size(), 5);
		assertEquals(train.getWagons().get(0), wagon1);
		assertEquals(train.getWagons().get(1), wagon2);
		assertEquals(train.getWagons().get(2), wagon3);
		assertEquals(train.getWagons().get(3), wagon4);
		assertEquals(train.getWagons().get(4), wagon5);
		
		assertEquals(train.getPower(), 4);
		
		// Test to move when the locomotive on this train don't have enough power
		try {
    		RailRoad railRoad = new RailRoad(new StraightRail(10.1), new StraightRail(10.1));
    		train.move(railRoad);
            fail("Expected an exception to be thrown.");
        } catch (Exception e) {
        	String message = "This train can't move because there are to much wagons. You should add a locomotive or remove some wagons.";
            assertEquals(e.getMessage(), message);
        }
	}
}
