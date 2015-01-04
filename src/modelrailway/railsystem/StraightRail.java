package modelrailway.railsystem;

/**
 * TODO
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class StraightRail extends BaseRail {
	private double length;
	private BaseRail connectionB;
	
	public StraightRail() {
		super(15.5);
	}

	public StraightRail(double length) {
		super(length);
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

	@Override
	public void connect(BaseRail railToConnect) throws Exception {
		if(this.connectionA == null) {
			this.connectionA = railToConnect;
		}
		
		else if(this.connectionB == null) {
			this.connectionB  = railToConnect;
		}
		
		else {
			throw new Exception("This forks connections are already used. You can't change these connections.");
		}
	}
}
