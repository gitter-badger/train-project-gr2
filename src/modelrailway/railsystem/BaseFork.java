package modelrailway.railsystem;

import java.util.Map;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */
public class BaseFork extends BaseRail {
	private String currentDirection;
	private Map possibleDirections;
	private String type;
	protected double radius;
	protected double angle;
	private BaseRail connectionB;
	private BaseRail connectionC;
	
	public BaseFork(String type, BaseRail connectionA, BaseRail connectionB, BaseRail connectionC) {
		super(15.5, connectionA);
		
		this.currentDirection = "A-B";
		// this.possibleDirections.
		this.type = type;
		this.radius = 31.5;
		this.angle = 30.0;

		this.connectionB = connectionB;
		this.connectionC = connectionC;
	}
	
	public BaseFork(Map possibleDirections, String type, double radius, double angle, double length, 
			BaseRail connectionA, BaseRail connectionB, BaseRail connectionC) {
		
		super(length,connectionA);
		
		this.currentDirection = "A-B";
		// TODO: this.possibleDirections = possibleDirections;
		this.type = type;
		this.radius = radius;
		this.angle = angle;
		this.connectionB = connectionB;
		this.connectionC = connectionC;
	}

	public String getCurrentDirection() {
		return currentDirection;
	}
	
	public void setDirection(String newDirection) {
		// Iterate through possibleDirections and set currentDirection
	}

	public Map getPossibleDirections() {
		return possibleDirections;
	}

	/**
	 * Defines if the curve goes to right or to left
	 * @return 'left' or 'right'
	 */
	public String getType() {
		return type;
	}

	public double getRadius() {
		return radius;
	}

	public double getAngle() {
		return angle;
	}

	public double getLengthCurve() {		
		return (radius * 2 * Math.PI) / 360 * angle;
	}
	
	public double getLengthStraight() {		
		return length;
	}
	
	public double getLength() {
		if(currentDirection == "A-B" || currentDirection == "B-A") {
			return getLengthStraight();
		}
		return getLengthCurve();
	}

	public String getConnectionB() {
		return connectionB;
	}

	public String getConnectionC() {
		return connectionC;
	}	
}
