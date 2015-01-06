package modelrailway.railsystem;


/**
 * TODO
 * 
 * @author Remo Doerig
 * @version 1.0
 */
public class StraightWithConnection extends StraightRail {
	private double entryVoltage;
	
	/**
	 * Constructor for a default straight with connection.
	 * @param Trafo
	 */
	public StraightWithConnection() {
		super(7.75);
		
		this.entryVoltage = 3.5;
	}
	/**
	 * Constructor for a default straight from a trafo
	 * @param Trafo
	 */
	public StraightWithConnection(Trafo trafo) {
		super(7.75);
		
		this.entryVoltage = trafo.getOutputVoltage();
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
	 * Returns the voltage that enters at this connection.
	 * @return entryVoltage
	 */
	public double getEntryVoltage() {
		return entryVoltage;
	}
}
