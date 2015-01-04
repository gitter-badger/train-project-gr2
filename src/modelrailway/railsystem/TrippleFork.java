package modelrailway.railsystem;

import modelrailway.helper.Direction;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class TrippleFork extends BaseFork {
	private BaseRail connectionD;
	
	/**
	 * Constructor for a default tripplefork
	 */
	public TrippleFork() {
		super("tripple");
		
		addPossibleDirection(new Direction("A","D"));
	}
	
	/**
	 * Constructor for a non-default tripplefork
	 */
	public TrippleFork(double radius, double angle, double length) {
		super("tripple", radius, angle, length);
		
		addPossibleDirection(new Direction("A","D"));
	}

	/**
	 * Returns the baserail connected to point D.
	 * @return
	 */
	public BaseRail getConnectionD() {
		return connectionD;
	}

	/**
	 * Sets a baserail to point D.
	 * @param connectionD
	 */
	public void setConnectionD(BaseRail connectionD) {
		this.connectionD = connectionD;
	}
		
	@Override
	public void connect(BaseRail railToConnect) throws Exception {
		if(this.getConnectionA() == null) {
			setConnectionA(railToConnect);
		}
		
		else if(getConnectionB() == null) {
			setConnectionB(railToConnect);
		}
		
		else if(this.getConnectionC() == null) {
			setConnectionC(railToConnect);
		}
		
		else if(this.getConnectionD() == null) {
			setConnectionD(railToConnect);
		}
		
		else {
			throw new Exception("This forks connections are already used. You can't change these connections.");
		}
	}
}
