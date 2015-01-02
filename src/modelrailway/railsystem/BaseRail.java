package modelrailway.railsystem;

import modelrailway.BaseObject;

/**
 * This class is the base class for all rails
 * It contains common informations
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public abstract class BaseRail extends BaseObject {
	/**
	 * The type of the rail
	 */
	private String trailType = "H0";
	
	/**
	 * The connection to this rail
	 */
	protected BaseRail connectionA;
	
	/**
	 * The length of the rail
	 * not the direct line between point A and B, but
	 * the actual length of the rail
	 * the length is in cm
	 */
	protected double length;
	
	/**
	 * Constructor for BaseRail
	 * @param length the length of this rail
	 */
	public BaseRail(double length) {
		super();
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
	 * @param length the length to set.
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	/**
	 * Connects this connection to another one.
	 * @param railToConnection
	 */
	public abstract void connect(BaseRail railToConnect);
}
