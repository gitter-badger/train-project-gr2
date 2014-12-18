package modelrailway.railsystem;

/**
 * @author remo.doerig
 * @version 1.0
 */
public class BufferStop extends BaseRail {
	
	private String type = "Holz";

	
	public BufferStop(BaseRail connectionA) {
		super(2.0,connectionA);
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
