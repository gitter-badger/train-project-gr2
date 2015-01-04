package modelrailway.vehicles;

import java.util.List;

import modelrailway.BaseObject;

/**
 * This class describes a train. A train is a composition of 1 locomotive at least and 0 or more wagons.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class Train extends BaseObject {
	/**
	 * A list of all locomotives in this train
	 */
	private List<Locomotive> locomotives;
	/**
	 * A list of all wagons in this train
	 */
	private List<Wagon> wagons;

	/**
	 * Constructor for the most primitive example of a train with just 1 locomotive an 0 wagons.
	 * @param locomotive, this locomotive will be added to this train
	 */
	public Train(Locomotive locomotive) {
		super();
		this.locomotives.add(locomotive);
	}
	
	/**
	 * Constructor to create a normal train with 1 or more locomotives and 1 or more wagons.
	 * @param locomotivesm, the list of locomotives which should be added to this train
	 * @param wagons, the list of wagons which should be added to this train
	 * @throws Exception if locomotives doesn't contain at least one item
	 */
	public Train(List<Locomotive> locomotives, List<Wagon> wagons) throws Exception {
		super();
		if(!locomotives.isEmpty()) {
			this.locomotives = locomotives;		
			this.wagons = wagons;
		}
		else {
			Exception exception = new Exception("Please add at least one locomotive");
			throw exception;
		}
	}
	
	/**
	 * This method adds a wagon to this train
	 * @param wagon, this wagon will be added to this train
	 */
	public void addWagon(Wagon wagon) {
		this.wagons.add(wagon);
	}
	
	/**
	 * This method adds a locomotive to this train
	 * @param locomotive, this locomotive will be added to this train
	 */
	public void addLocomotive(Locomotive locomotive) {
		this.locomotives.add(locomotive);
	}
	
	/**
	 * This method returns all locomotives in this train
	 * @return List<Locomotive>
	 */
	public List<Locomotive> getLocomotives() {
		return this.locomotives;
	}
	
	public int getPower() {
		int power = 0;
		
		for(Locomotive locomotive : this.locomotives) {
			power = power + locomotive.getPower();
		}
		
		return power;
	}
	
	/**
	 * This method returns all wagons in this train
	 * @return List<Wagon>
	 */
	public List<Wagon> getWagons() {
		return this.wagons;
	}
	
	public void move() throws Exception {
		if(getPower() >= this.wagons.size()) {
			
		}
		else {
			throw new Exception("This train can't move because there are to much wagons. You should add a locomotive or remove some wagons");
		}
	}
}
