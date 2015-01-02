package modelrailway.railsystem;

/**
 * @author remo.doerig
 * @version 1.0
 */
public class BufferStop extends BaseRail {	
	private String type = "Holz";

	/**
	 * Constructor for a default buffer stop.
	 */
	public BufferStop() {
		super(2.0);
	}
	
	/**
	 * Constructor for a non-default buffer stop.
	 * @param length TODO
	 * @param type TODO
	 */
	public BufferStop(double length, String type) {
		super(length);
		this.type = type;
	}

	/**
	 * Returns the type of this buffer stop.
	 * @return TODO
	 */
	public String getType() {
		return type;
	}

	@Override
	public void connect(BaseRail railToConnect) {
		if(this.connectionA == null) {
			connectionA = railToConnect;
		}
		
		else {
			System.out.println("This rails connection is already used. You cant change this connection");			
		}
	}
}
