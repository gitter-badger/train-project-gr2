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
	
	public Direction(String startPoint, String endPoint) {
		this.startPoint = startPoint.toUpperCase();
		this.endPoint = endPoint.toUpperCase();
	}

	public String getStringified() {
		return startPoint + ">" + endPoint; 
	}
	
	public String getStringifiedReverse() {
		return endPoint + ">" + startPoint; 
	}
}
