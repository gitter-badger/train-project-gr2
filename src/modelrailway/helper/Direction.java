package modelrailway.helper;

/**
 * This class describes a direction which can be active at a fork. 
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class Direction {
	private String startPoint;
	private String endPoint;
	
	/**
	 * Constructor for a new direction.
	 * @param startPoint
	 * @param endPoint
	 */
	public Direction(String startPoint, String endPoint) {
		this.startPoint = startPoint.toUpperCase();
		this.endPoint = endPoint.toUpperCase();
	}
	
	/**
	 * Returns the string of this direction.
	 * @return "A>B" or something like that.
	 */
	public String getStringified() {
		return startPoint + ">" + endPoint; 
	}
	
	/**
	 * Returns the reversed string of this direction.
	 * @return "B>A" or something like that.
	 */
	public String getStringifiedReverse() {
		return endPoint + ">" + startPoint; 
	}
}
