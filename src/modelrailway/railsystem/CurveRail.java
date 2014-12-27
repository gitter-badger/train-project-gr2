package modelrailway.railsystem;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class CurveRail extends BaseRail {
	private double angle;
	private double radius;
	private BaseRail connectionB;
	
	public CurveRail(double angle, double radius, BaseRail connectionA, BaseRail connectionB) {
		super((radius * 2 * Math.PI) / 360 * angle, connectionA);
		
		this.angle = angle;
		this.radius = radius;
		this.connectionB = connectionB;
	}
	
	public BaseRail getConnectionB() {
		return connectionB;
	}
	
	public void setConnectionB(BaseRail connectionB) {
		this.connectionB = connectionB;
	}
	
	public double getLength() {		
		return (radius * 2 * Math.PI) / 360 * angle;
	}
}