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
	 * summed from all the Railparts
	 */
	private double length;
	
	/**
	 * The starting Point of the Railroad
	 */
	private String startPoint;
	
	/**
	 * The end Point of the Railroad
	 */
	private String endPoint;
	
	/**
	 * A road can not be passed the forks are set wrong,
	 * or a train is currently on the railroad 
	 */
	private boolean isPassable;
	
	public RailRoad(String startPoint,String endPoint) {
		super();
		this.setStartPoint(startPoint);
		this.setEndPoint(endPoint);
	}

	/**
	 * @return the startPoint
	 */
	public String getStartPoint() {
		return startPoint;
	}

	/**
	 * @param startPoint the startPoint to set
	 */
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * @return the endPoint
	 */
	public String getEndPoint() {
		return endPoint;
	}

	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

}
