package modelrailway.vehicles;

/**
 * This class describes a wagon.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class Wagon extends TrainPart{
	private double capacity;
	private String color;
	
	/**
	 * Constructor for a default wagon.
	 */
	public Wagon() {
		super("people");

		this.capacity = 50;
		this.color = "blue";
	}
	
	/**
	 * Constructor for a non-default wagon.
	 * @param type
	 * @param capacity
	 * @param colour
	 */
	public Wagon(String type, double capacity, String color) {
		super(type);
		
		this.capacity = capacity;
		this.color = color;
	}

	/**
	 * Returns the color of this wagon.
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Returns the capacity of this wagon.
	 * @return capacity
	 */
	public double getCapacity() {
		return capacity;
	}	
}
