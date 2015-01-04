package modelrailway.railsystem; 

import java.util.ArrayList;
import java.util.List;

import modelrailway.helper.Direction;

/**
 * This class describes the simplest available fork. One way over a curve and one way straight on.
 *
 * @author Marco Endres, Simon Styger
 * @version 1.0
 */
public class BaseFork extends BaseRail {
	private String type;
	private BaseRail connectionB;
	private BaseRail connectionC;
	private Direction currentDirection;
	private List<Direction> possibleDirections;
	protected double radius;
	protected double angle;
	
	/**
	 * Constructor for a default fork.
	 * @param type defines if the curve on this fork goes to right or to left.
	 */
	public BaseFork(String type) {
		super(15.5);

		this.currentDirection = new Direction("A","B");
		this.possibleDirections = new ArrayList<Direction>();
		this.possibleDirections.add(new Direction("A","B"));
		this.possibleDirections.add(new Direction("A","C"));
		
		this.type = type.toLowerCase();
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

		this.currentDirection = new Direction("A","B");
		this.possibleDirections = new ArrayList<Direction>();
		this.possibleDirections.add(new Direction("A","B"));
		this.possibleDirections.add(new Direction("A","C"));
		
		this.type = type.toLowerCase();
		this.radius = radius;
		this.angle = angle;
	}

	/**
	 * Returns the way a train will take if he will cross this fork.
	 * @return currentDirection
	 */
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	
	/**
	 * Returns all possible directions on this fork.
	 * @return possibleDirections
	 */
	public List<Direction> getPossibleDirections() {
		return this.possibleDirections;
	}
	
	/**
	 * 
	 */
	protected void addPossibleDirection(Direction possibleDirection) {
		this.possibleDirections.add(possibleDirection);
	}
	
	/**
	 * Changes the current direction on this fork an changes the way a train will take.
	 * @param newDirection
	 * @throws Exception 
	 */
	public boolean changeDirection(Direction newDirection) throws Exception {
		for(Direction direction : possibleDirections) {
			if(newDirection.getStringified().equals(direction.getStringified())) {
				this.currentDirection = newDirection;
				return true;
			}
			
			else if(newDirection.getStringified().equals(direction.getStringifiedReverse())) {
				this.currentDirection = newDirection;	
				return true;			
			}
		}
		throw new Exception("It's impossible to set this direction, please try another one.");
	}

	/**
	 * Returns if the curve on this fork goes to right or to left.
	 * @return 'left' or 'right'
	 */
	public String getType() {
		return type.toLowerCase();
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
	 * @return length of curve
	 */
	public double getLengthCurve() {		
		return (radius * 2 * Math.PI) / 360 * angle;
	}
	
	/**
	 * Returns the length of the straight part of this fork.
	 * @return length of straight part
	 */
	public double getLengthStraight() {		
		return length;
	}
	
	/**
	 * Returns the effective length of this fork over the curve or over the straight way.
	 * @return effective length
	 */
	@Override
	public double getLength() {
		String direction = currentDirection.getStringified();
		if(direction.equals("A>B") || direction.equals("B>A")) {
			return getLengthCurve();
		}
		return getLengthStraight();
	}

	/**
	 * Returns the connection B.
	 * @return TODO
	 */
	public BaseRail getConnectionB() {
		return connectionB;
	}
	
	/**
	 * Sets the connection B.
	 * @param connection
	 */
	protected void setConnectionB(BaseRail connectionB) {
		this.connectionB = connectionB;
	}

	/**
	 * Returns the connection C.
	 * @return TODO
	 */
	public BaseRail getConnectionC() {
		return connectionC;
	}
	
	/**
	 * Sets the connection C.
	 * @param connection
	 */
	protected void setConnectionC(BaseRail connectionC) {
		this.connectionC = connectionC;
	}

	@Override
	public void connect(BaseRail railToConnect) throws Exception {
		if(this.connectionA == null) {
			this.setConnectionA(railToConnect);
		}
		
		else if(this.connectionB == null) {
			this.setConnectionB(railToConnect);
		}
		
		else if(this.connectionC == null) {
			this.setConnectionC(railToConnect);
		}
		
		else {
			throw new Exception("This forks connections are already used. You can't change these connections.");
		}
	}
}
