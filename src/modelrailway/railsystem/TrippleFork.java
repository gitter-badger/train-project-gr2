package modelrailway.railsystem;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class TrippleFork extends BaseFork {
	private String connectionD;
	

	public TrippleFork(String type, String connectionB, String connectionC, String connectionD) {
		super(type, connectionB, connectionC);

		this.connectionD = connectionD;
		// TODO add new direction to possible Directions
	}
}
