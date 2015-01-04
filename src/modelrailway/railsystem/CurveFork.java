package modelrailway.railsystem;

/**
 * TODO
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class CurveFork extends BaseFork {
	private double radiusBig;
	private double angleBig;
	
	public CurveFork(String type) {
		super(type);
		
		this.radiusBig = 35.3;
		this.angleBig = 30.0;
	}
		
	public CurveFork(String type, double angleSmall, double radiusSmall, double angleBig, double radiusBig)
	{
		super(type);
		
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
	
	@Override
	public double getLengthCurve() {
		return 0.0;
	}
	
	@Override
	public double getLengthStraight() {
		return 0.0;
	}
}
