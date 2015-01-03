package modelrailway.railsystem;

import modelrailway.helper.Direction;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class TrippleFork extends BaseFork {
	private BaseRail connectionD;
	
	public TrippleFork() {
		super("tripple");
		
		addPossibleDirection(new Direction("A","C"));
	}

	public BaseRail getConnectionD() {
		return connectionD;
	}

	public void setConnectionD(BaseRail connectionD) {
		this.connectionD = connectionD;
	}	
	
	@Override
	public void connect(BaseRail railToConnect) {
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
			System.out.println("This rails connections are already used. You cant change these connections");
		}
	}
}
