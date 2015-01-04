package modelrailway.railsystem;


/**
 * TODO
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public class StraightWithConnection extends StraightRail {
	/**
	 * The voltage that enters from the trafo.
	 */
	private double entryVoltage;
	
	/**
	 * Constructor for a default straight with connection.
	 */
	public StraightWithConnection() {
		super(7.75);
		
		this.entryVoltage = 3.5;
	}

	/**
	 * Constructor for a non-default straight with connection.
	 * @param length
	 * @param voltage
	 */
	public StraightWithConnection(double length, double voltage) {
		super(length);

		this.entryVoltage = voltage;
	}

	/**
	 * @return the voltage that enters at this connection.
	 */
	public double getEntryVoltage() {
		return entryVoltage;
	}
}
