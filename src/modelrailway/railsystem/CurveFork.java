package modelrailway.railsystem;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class CurveFork extends BaseFork {
	private double radiusBig;
	private double angleBig;
	
	public CurveFork(String type, BaseRail connectionA, BaseRail connectionB, BaseRail connectionC) {
		super(type, connectionA, connectionB, connectionC);
		
		this.radiusBig = 35.3;
		this.angleBig = 30.0;
	}
		
	public CurveFork(String type, BaseRail connectionA, BaseRail connectionB, BaseRail connectionC, double angleSmall, double radiusSmall, 
			double angleBig, double radiusBig)
	{
		super(type, connectionA, connectionB, connectionC);
		
		this.radius = radiusSmall;
		this.angle = angleSmall;
		this.radiusBig = radiusBig;
		this.angleBig = angleBig;
	}

	public double getRadiusBig() {
		return radiusBig;
	}

	public double getAngleBig() {
		return angleBig;
	}
	
	public double getLengthBig() {
		return (radiusBig * 2 * Math.PI) / 360 * angleBig;
	}
	
	public double getRadiusSmall() {
		return radius;
	}

	public double getAngleSmall() {
		return angle;
	}
	
	public double getLengthSmall() {
		return (radius * 2 * Math.PI) / 360 * angle;		
	}
}
