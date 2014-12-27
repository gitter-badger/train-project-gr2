package modelrailway.railsystem;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class TrippleFork extends BaseFork {
	private BaseRail connectionD;
	

	public TrippleFork(String type, BaseRail connectionA, BaseRail connectionB, BaseRail connectionC, BaseRail connectionD) {
		super(type, connectionA, connectionB, connectionC);

		this.connectionD = connectionD;
		// TODO add new direction to possible Directions
	}
}
