package modelrailway.vehicles;

/**
 * This class describes the wagon.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class Wagon extends TrainPart{
	private double capacity;
	private String colour;
	
	/**
	 * Constructor for a default wagon.
	 */
	public Wagon() {
		super("person");

		this.capacity = 50;
		this.colour = "blue";
	}
	
	/**
	 * Constructor for a non-default wagon.
	 * @param type
	 * @param capacity
	 * @param colour
	 */
	public Wagon(String type, double capacity, String colour) {
		super(type);
		
		this.capacity = capacity;
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	public double getCapacity() {
		return capacity;
	}	
}
