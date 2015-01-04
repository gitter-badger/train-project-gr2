package modelrailway.vehicles;

import modelrailway.BaseObject;

/**
 * This class describes a part of a train that means a locomotive or a wagon
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class TrainPart extends BaseObject {
	private int axes;
	private String type;
	
	public TrainPart(String type) {
		super();

		this.axes = 2;
		this.type = type;
	}
	
	public TrainPart(String type, int axes) {
		super();

		this.axes = axes;
		this.type = type;
	}

	public int getAxes() {
		return axes;
	}

	public String getType() {
		return type;
	}
}
