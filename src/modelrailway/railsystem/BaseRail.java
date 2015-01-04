package modelrailway.railsystem;

import modelrailway.BaseObject;

/**
 * This class is the base class for all rails.
 * It contains common informations.
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public abstract class BaseRail extends BaseObject {
	private String trailType = "H0";
	protected BaseRail connectionA;
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
	 * Returns the trailtype of this rail.
	 * @return trailType
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
	 * Returns
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
	 * @throws Exception 
	 */
	public double getLength() throws Exception {
		return length;
	}

	/**
	 * @param length the length to set.
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	/**
	 * Connects another rail to this rail.
	 * @param railToConnect
	 * @throws Exception
	 */
	public abstract void connect(BaseRail railToConnect) throws Exception;
}
