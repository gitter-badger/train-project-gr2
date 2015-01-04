package modelrailway.vehicles;

import modelrailway.BaseObject;

/**
 * This class describes a part of a train. That means a locomotive or a wagon
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class TrainPart extends BaseObject {
	private int axes;
	private String type;
	
	/**
	 * Constructor for a default train-part.
	 * @param type
	 */
	public TrainPart(String type) {
		super();

		this.axes = 2;
		this.type = type;
	}
	
	/**
	 * Constructor for a non-default train-part.
	 * @param type
	 * @param axes
	 */
	public TrainPart(String type, int axes) {
		super();

		this.axes = axes;
		this.type = type;
	}

	/**
	 * Returns the axes of this locomotive or wagon.
	 * @return axes
	 */
	public int getAxes() {
		return axes;
	}

	/**
	 * Returns the type of this locomotive or wagon.
	 * @return type
	 */
	public String getType() {
		return type;
	}
}
