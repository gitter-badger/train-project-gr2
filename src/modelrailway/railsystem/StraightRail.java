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
	
	/**
	 * Constructor for a default straight rail.
	 */
	public StraightRail() {
		super(15.5);
	}

	/**
	 * Constructor for a default straight rail.
	 * @param length
	 */
	public StraightRail(double length) {
		super(length);
	}
	
	/**
	 * Returns the baserail connected to point B.
	 * @return
	 */
	public BaseRail getConnectionB() {
		return connectionB;
	}
	
	/**
	 * Sets a baserail to point D.
	 * @param connectionB
	 */
	public void setConnectionB(BaseRail connectionB) {
		this.connectionB = connectionB;
	}
	
	/**
	 * Returns the length of this rail.
	 * @return length
	 */
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
