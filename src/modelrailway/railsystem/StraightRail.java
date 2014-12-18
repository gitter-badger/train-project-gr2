package modelrailway.railsystem;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class StraightRail extends BaseRail {
	private double length;
	private String connectionB;

	public StraightRail(double length, String connectionA, String connectionB) {
		super(connectionA);
		this.length = length;
		this.connectionB = connectionB;
	}
	
	public String getConnectionB() {
		return connectionB;
	}
	
	public void setConnectionB(String connectionB) {
		this.connectionB = connectionB;
	}
	
	public double getLength() {
		return length;
	}
}
