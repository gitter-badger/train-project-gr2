package modelrailway.railsystem;

import modelrailway.BaseObject;


/**
 * This class describes a Railroad
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public class RailRoad extends BaseObject {
	private BaseRail startPoint;
	private BaseRail endPoint;
	
	/**
	 * Constructor for a new RailRoad.
	 * @param startPoint
	 * @param endPoint
	 */
	public RailRoad(BaseRail startPoint, BaseRail endPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
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

}
