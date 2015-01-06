package modelrailway.railsystem;

/**
 * BaseClass for all Rails, which can be passed, like a straight or curved rail
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public abstract class BaseRailPassable extends BaseRail {
	/**
	 * The Second connection
	 */
	private BaseRail connectionB;
	
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
	
	public BaseRailPassable(double length) {
		super(length);
	}

}
