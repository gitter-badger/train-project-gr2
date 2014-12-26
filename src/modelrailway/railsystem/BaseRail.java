package modelrailway.railsystem;

import modelrailway.BaseObject;

/**
 * This Class is the Base Class for all Rails
 * It contains common Information
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public abstract class BaseRail extends BaseObject {

	/**
	 * The type of the trail
	 */
	private String trailType = "H0";
	
	/**
	 * The Connection to this Rail
	 */
	private BaseRail connectionA;
	
	/**
	 * The length of the rail
	 * not the direct line between point A and B, but
	 * the actual length of the rail
	 * the length is in cm
	 */
	protected double length;
	
	public BaseRail(double length,BaseRail connectionA) {
		super();
		this.setConnectionA(connectionA);
		this.setLength(length);
	}

	/**
	 * @return the trailType
	 */
	 public String getTrailType() {
		return trailType;
	}

	/**
	 * @param trailType, the trailType to set
	 */
	public void setTrailType(String trailType) {
		this.trailType = trailType;
	}

	/**
	 * @return the connectionA
	 */
	public BaseRail getConnectionA() {
		return connectionA;
	}

	/**
	 * @param connectionA the connectionA to set
	 */
	public void setConnectionA(BaseRail connectionA) {
		this.connectionA = connectionA;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
}
