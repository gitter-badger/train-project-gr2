package modelrailway.railsystem;

/**
 * TODO
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class CurveRail extends BaseRailPassable {
	private double angle;
	private double radius;
	
	/**
	 * Constructor for a default curverail.
	 */
	public CurveRail() {
		super((31.5 * 2 * Math.PI) / 360 * 30.0);
		
		this.angle = 30.0;
		this.radius = 31.5;
	}
	
	/**
	 * Constructor for a non-default curverail.
	 * @param angle
	 * @param radius
	 */
	public CurveRail(double angle, double radius) {
		super((radius * 2 * Math.PI) / 360 * angle);
		
		this.angle = angle;
		this.radius = radius;
	}
	
	/**
	 * Returns the radius of this curve.
	 * @return radius
	 */
	public double getRadius() {		
		return radius;
	}
	
	/**
	 * Returns the angle of this curve.
	 * @return curve
	 */
	public double getAngle() {		
		return angle;
	}
	
	/**
	 * Returns the length of this curve.
	 * @param length
	 */
	@Override
	public double getLength() {		
		return (radius * 2 * Math.PI) / 360 * angle;
	}

	@Override
	public void connect(BaseRail railToConnect) throws Exception {
		if(this.connectionA == null) {
			this.connectionA = railToConnect;
		}
		
		else if(this.getConnectionB() == null) {
			this.setConnectionB(railToConnect);
		}
		
		else {
			throw new Exception("This forks connections are already used. You can't change these connections.");
		}
	}
}