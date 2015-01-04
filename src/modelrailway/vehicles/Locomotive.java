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
	 * Constructor for a default locomotive;
	 */
	public Locomotive() {
		super("electricity");

		this.power = 10;
	}
	
	public Locomotive(String type, int power) {			
		super(type);	
		
		this.power = power;
	}		
	
	public int getPower() {
		return power;
	}
}