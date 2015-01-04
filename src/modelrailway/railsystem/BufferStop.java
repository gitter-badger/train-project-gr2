package modelrailway.railsystem;

/**
 * TODO
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public class BufferStop extends BaseRail {	
	private String type;

	/**
	 * Constructor for a default buffer stop.
	 */
	public BufferStop() {
		super(2.0);
		this.type = "holz";
	}
	
	/**
	 * Constructor for a non-default buffer stop.
	 * @param length
	 * @param type
	 */
	public BufferStop(double length, String type) {
		super(length);
		this.type = type.toLowerCase();
	}

	/**
	 * Returns the type of this buffer stop.
	 * @return type
	 */
	public String getType() {
		return type.toLowerCase();
	}

	@Override
	public void connect(BaseRail railToConnect) throws Exception {
		if(this.connectionA == null) {
			connectionA = railToConnect;
		}
		
		else {
			throw new Exception("This rails connection is already used. You cant change this connection.");	
		}
	}
}
