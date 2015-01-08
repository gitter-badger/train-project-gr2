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
	
	/**
	 * Constructor for a default curvefork.
	 * @param type
	 */
	public CurveFork(String type) {
		super(type);
		
		this.radiusBig = 35.3;
		this.angleBig = 30.0;
	}

	/**
	 * Constructor for a non-default curvefork.
	 * @param type
	 * @param angleSmall
	 * @param radiusSmall
	 * @param angleBig
	 * @param radiusBig
	 */
	public CurveFork(String type, double angleSmall, double radiusSmall, double angleBig, double radiusBig)
	{
		super(type);

		if(radiusSmall > 50 || radiusSmall <= 0) {
			throw new java.lang.RuntimeException("invalid parameter");
		}
		if(angleSmall > 360 || angleSmall <= 0) {
			throw new java.lang.RuntimeException("invalid parameter");
		}
		if(radiusBig > 50  || radiusBig <= 0) {
			throw new java.lang.RuntimeException("invalid parameter");
		}
		if(angleBig > 360 || angleBig <= 0) {
			throw new java.lang.RuntimeException("invalid parameter");
		}
		this.radius = radiusSmall;
		this.angle = angleSmall;
		this.radiusBig = radiusBig;
		this.angleBig = angleBig;
	}


	/**
	 * Returns the lenght of the outter curve.
	 * @return length
	 */
	public double getLengthBig() {
		return (radiusBig * 2 * Math.PI) / 360 * angleBig;
	}
	
	/**
	 * Returns the length of the inner curve.
	 * @return length
	 */
	public double getLengthSmall() {
		return (radius * 2 * Math.PI) / 360 * angle;
	}
	
	/**
	 * Overrides this method because it's not available on this fork.
	 * @throws Exception 
	 */
	@Override
	public double getLengthCurve() throws Exception {
		throw new Exception("This method is not available on this class.");
	}
	
	/**
	 * Overrides this method because it's not available on this fork.
	 * @throws Exception 
	 */	
	@Override
	public double getLengthStraight() throws Exception {
		throw new Exception("This method is not available on this class.");
	}
}
