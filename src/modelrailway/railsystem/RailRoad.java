package modelrailway.railsystem;

import modelrailway.BaseObject;


/**
 * This class describes a Railroad
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public class RailRoad extends BaseObject {
	
	/**
	 * Length of the Railroad
	 * summed from all the rails in this railroad.
	 */
	private double length;
	
	/**
	 * The starting point of the railroad.
	 */
	private BaseRail startPoint;
	
	/**
	 * The end point of the railroad.
	 */
	private BaseRail endPoint;
	
	/**
	 * A road can not be passed the forks are set wrong,
	 * or a train is currently on the railroad.
	 */
	private boolean isPassable;
	
	/**
	 * Constructor for a new RailRoad.
	 * @param startPoint
	 * @param endPoint
	 */
	public RailRoad(BaseRail startPoint, BaseRail endPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
		this.length = 0.0;
	}

	/**
	 * @return the startPoint.
	 */
	public BaseRail getStartPoint() {
		return startPoint;
	}

	/**
	 * @return the endPoint.
	 */
	public BaseRail getEndPoint() {
		return endPoint;
	}

	/**
	 * @return if these railroad is passable.
	 */
	public boolean isPassable() {
		return isPassable;
	}

	
	/**
	 * @return the length of this railroad.
	 */
	public double getLength() {
		return length;
	}
}
