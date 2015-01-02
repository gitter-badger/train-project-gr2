package modelrailway.railsystem;

import java.util.Map;

/**
 * TODO
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */
public class BaseFork extends BaseRail {
	private Map possibleDirections;
	private String type;
	private String currentDirection;
	private BaseRail connectionB;
	private BaseRail connectionC;
	protected double radius;
	protected double angle;
	
	/**
	 * Constructor for a default fork.
	 * @param type defines if the curve on this fork goes to right or to left.
	 */
	public BaseFork(String type) {
		super(15.5);
		
		this.currentDirection = "A-B";
		// TODO: this.possibleDirections = possibleDirections;
		this.type = type;
		this.radius = 31.5;
		this.angle = 30.0;
	}
	
	/**
	 * Constructor for a non-default fork.
	 * @param type defines if the curve on this fork goes to right or to left.
	 * @param radius defines the radius of the curve of this fork.
	 * @param angle defines the angle of the curve of this fork.
	 * @param length defines the length of the straight part of this fork.
	 */
	public BaseFork(String type, double radius, double angle, double length) {
		super(length);
		
		this.currentDirection = "A-B";
		// TODO: this.possibleDirections = possibleDirections;
		this.type = type;
		this.radius = radius;
		this.angle = angle;
	}

	/**
	 * Returns the way a train will take if he will cross this fork.
	 * @return TODO
	 */
	public String getCurrentDirection() {
		return currentDirection;
	}
	
	/**
	 * Returns all possible directions on this fork.
	 * @return TODO
	 */
	public Map getPossibleDirections() {
		return this.possibleDirections;
	}
	
	/**
	 * Changes the current direction on this fork an changes the way a train will take.
	 * @param TODO
	 */
	public void setDirection(String newDirection) {
		// TODO: Iterate through possibleDirections and set currentDirection
	}

	/**
	 * Returns if the curve on this fork goes to right or to left.
	 * @return 'left' or 'right'
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns the radius of the curve of this fork.
	 * @return TODO
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Returns the angle of the curve of this fork.
	 * @return TODO
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * Returns the length of the curve of this fork.
	 * @return TODO
	 */
	public double getLengthCurve() {		
		return (radius * 2 * Math.PI) / 360 * angle;
	}
	
	/**
	 * Returns the length of the straight part of this fork.
	 * @return TODO
	 */
	public double getLengthStraight() {		
		return length;
	}
	
	/**
	 * Returns the effective length of this fork over the curve or over the straight way.
	 * @return TODO
	 */
	public double getLength() {
		if(currentDirection == "A-B" || currentDirection == "B-A") {
			return getLengthStraight();
		}
		return getLengthCurve();
	}

	/**
	 * Returns the connection at the end of the curve.
	 * @return TODO
	 */
	public BaseRail getConnectionB() {
		return connectionB;
	}

	/**
	 * Returns the connection at the end of the straight way.
	 * @return TODO
	 */
	public BaseRail getConnectionC() {
		return connectionC;
	}

	@Override
	public void connect(BaseRail railToConnect) {
		if(this.connectionA == null) {
			this.connectionA = railToConnect;
		}
		
		else if(this.connectionB == null) {
			this.connectionB = railToConnect;
		}
		
		else if(this.connectionC == null) {
			this.connectionC = railToConnect;
		}
		
		else {
			System.out.println("This rails connections are already used. You cant change these connections");
		}
	}
}
