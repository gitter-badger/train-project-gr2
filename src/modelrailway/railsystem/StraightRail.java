package modelrailway.railsystem;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class StraightRail extends BaseRail {
	private double length;
	private BaseRail connectionB;

	public StraightRail(double length, BaseRail connectionA, BaseRail connectionB) {
		super(length, connectionA);
		this.length = length;
		this.connectionB = connectionB;
	}
	
	public BaseRail getConnectionB() {
		return connectionB;
	}
	
	public void setConnectionB(BaseRail connectionB) {
		this.connectionB = connectionB;
	}
	
	public double getLength() {
		return length;
	}
}
