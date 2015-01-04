package modelrailway.vehicles;

/**
 * This class describes a locomotive.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class Locomotive extends TrainPart{
	private int power;

	/**
	 * Constructor for a default locomotive.
	 */
	public Locomotive() {
		super("electricity");

		this.power = 10;
	}
	
	/**
	 * Constructor for a non-default locomotive.
	 * @param type
	 * @param power
	 */
	public Locomotive(String type, int power) {			
		super(type);	
		
		this.power = power;
	}
	
	/**
	 * Constructor for a non-default locomotive with more then 2 axes.
	 * @param type
	 * @param power
	 */
	public Locomotive(String type, int power, int axes) {			
		super(type, axes);	
		
		this.power = power;
	}	
	
	/**
	 * Returns the power of this locomotive.
	 * @return power
	 */
	public int getPower() {
		return power;
	}
}