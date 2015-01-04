package modelrailway.railsystem;

import modelrailway.BaseObject;


/**
 * This class describes a Railroad
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public class RailRoad extends BaseObject {
	private double length;
	private BaseRail startPoint;
	private BaseRail endPoint;
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
	 * Returns the startpoint of this railroad.
	 * @return startPoint
	 */
	public BaseRail getStartPoint() {
		return startPoint;
	}

	/**
	 * Returns the endpoint of this railroad.
	 * @return endPoint
	 */
	public BaseRail getEndPoint() {
		return endPoint;
	}

	/**
	 * Returns if this railroad is passable.
	 * @return isPassable.
	 */
	public boolean isPassable() {
		return isPassable;
	}
	
	/**
	 * Returns the length of this railroad.
	 * @return length
	 */
	public double getLength() {
		return length;
	}
}
