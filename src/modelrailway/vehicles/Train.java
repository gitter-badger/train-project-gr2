package modelrailway.vehicles;

import java.util.ArrayList;
import java.util.List;

import modelrailway.BaseObject;
import modelrailway.railsystem.RailRoad;
import modelrailway.railsystem.BaseRail;
import modelrailway.railsystem.BaseRailPassable;
import modelrailway.railsystem.StraightRail;
import modelrailway.railsystem.BaseFork;

/**
 * This class describes a train. A train is a composition of 1 locomotive at least and 0 or more wagons.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class Train extends BaseObject {
	private List<Locomotive> locomotives;
	private List<Wagon> wagons;
	
	/**
	 * to assure the train doesn't move in circles
	 */
	private ArrayList<BaseRail> placesSeen = new ArrayList<BaseRail>();

	/**
	 * Constructor for the most primitive example of a train with just 1 locomotive an 0 wagons.
	 * @param locomotive, this locomotive will be added to this train.
	 */
	public Train(Locomotive locomotive) {
		super();
		
		this.locomotives = new ArrayList<Locomotive>();		
		this.locomotives.add(locomotive);
		
		this.wagons = new ArrayList<Wagon>();
	}
	
	/**
	 * Constructor to create a normal train with 1 or more locomotives and 1 or more wagons.
	 * @param locomotivesm, the list of locomotives which should be added to this train.
	 * @param wagons, the list of wagons which should be added to this train.
	 * @throws Exception if locomotives doesn't contain at least one item.
	 */
	public Train(List<Locomotive> locomotives, List<Wagon> wagons) throws Exception {
		super();
		if(!locomotives.isEmpty()) {
			this.locomotives = new ArrayList<Locomotive>();	
			this.locomotives = locomotives;		
			this.wagons = new ArrayList<Wagon>();
			this.wagons = wagons;
		}
		else {
			Exception exception = new Exception("Please add at least one locomotive");
			throw exception;
		}
	}
	
	/**
	 * This method adds a wagon to this train.
	 * @param wagon, this wagon will be added to this train.
	 */
	public void addWagon(Wagon wagon) {
		this.wagons.add(wagon);
	}
	
	/**
	 * This method adds a locomotive to this train.
	 * @param locomotive, this locomotive will be added to this train.
	 */
	public void addLocomotive(Locomotive locomotive) {
		this.locomotives.add(locomotive);
	}
	
	/**
	 * Returns all locomotives in this train.
	 * @return List<Locomotive>
	 */
	public List<Locomotive> getLocomotives() {
		return this.locomotives;
	}
	
	/**
	 * Returns all wagons in this train.
	 * @return List<Wagon>
	 */
	public List<Wagon> getWagons() {
		return this.wagons;
	}
		
	/**
	 * This method calculates the effective power of all locomotives of this train.
	 * @return power
	 */
	public int getPower() {
		int power = 0;
		
		for(Locomotive locomotive : this.locomotives) {
			power = power + locomotive.getPower();
		}
		
		return power;
	}
	
	/**
	 * sets the train on a new RailRoad
	 * @param railRoad
	 */
	public void setOnRailway(RailRoad railRoad) {
		placesSeen = new ArrayList<BaseRail>();
	}
	
	/**
	 * Moves this train over the overloaded railroad.
	 * @throws Exception
	 */
	public void move(RailRoad railRoad,char direction) throws Exception {
		if(getPower() >= this.wagons.size()) {
			BaseRail next;
			if(!(railRoad.getStartPoint() instanceof BaseRailPassable)) {
				throw new Exception("The Rails must be passable, otherwise the train can't move on them");
			}
			BaseRailPassable startPoint = (BaseRailPassable)railRoad.getStartPoint();
			RailRoad nextRailRoad;
			

			
			switch(direction) {
			case 'A':
			case 'a':
				next = startPoint.getConnectionA();
				if(next.getId().equals(startPoint.getConnectionB().getId())) {
					throw new Exception("Connection A and Connection B are the same");
				}
				break;
			case 'B':
			case 'b':
				next = startPoint.getConnectionB();
				if(next instanceof BaseFork) {
					if(((BaseFork)next).getCurrentDirection().getStringified().contains("C")) {
						next = ((BaseFork)next).getConnectionC();
					}
				}
				if(next.getId().equals(startPoint.getConnectionA().getId())) {
					throw new Exception("Connection A and Connection B are the same");
				}
				break;
			default:
				throw new Exception("direction must be either 'A' or 'B'");
			}
			if(placesSeen.contains(next)) {
				throw new Exception("The Place with ID = " + next.getId() + " has already been visited");
			}
			placesSeen.add(next);
			
			
			if(next.getId().equals(startPoint.getId()) && !next.getId().equals(railRoad.getEndPoint().getId())) {
				throw new Exception("Railroad is incorrect");
			}
			System.out.println("Moving train in direction '" + direction + "' to a " + next.getClass().toString() + " with ID = " + next.getId());
			System.out.println("Length:" + next.getLength());
			if(startPoint.getId().equals(railRoad.getEndPoint().getId())) {
				System.out.println("Finished a RailRoad");
				return;
			}
			if(next.getConnectionA().getId().equals(startPoint.getId())) {
				direction = 'B';
			}
			nextRailRoad = new RailRoad(next,railRoad.getEndPoint());
			this.move(nextRailRoad, direction);
		}
		else {
			throw new Exception("This train can't move because there are to much wagons. You should add a locomotive or remove some wagons.");
		}
	}
}
