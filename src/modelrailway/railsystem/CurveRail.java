package modelrailway.railsystem;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class CurveRail extends BaseRail {
	private double angle;
	private double radius;
	private String connectionB;
	
	public CurveRail(double angle, double radius, String connectionA, String connectionB) {
		super(connectionA);
		
		this.angle = angle;
		this.radius = radius;
		this.connectionB = connectionB;
	}
	
	public String getConnectionB() {
		return connectionB;
	}
	
	public void setConnectionB(String connectionB) {
		this.connectionB = connectionB;
	}
	
	public double getLength() {		
		return (radius * 2 * Math.PI) / 360 * angle;
	}
}