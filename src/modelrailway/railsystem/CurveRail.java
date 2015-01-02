package modelrailway.railsystem;

/**
 * 
 * @author Marco Endres & Simon Styger
 * @version 1.0
 */

public class CurveRail extends BaseRail {
	private double angle;
	private double radius;
	private BaseRail connectionB;
	
	public CurveRail() {
		super((31.5 * 2 * Math.PI) / 360 * 30.0);
		
		this.radius = 31.5;
		this.angle = 30.0;
	}
	
	public CurveRail(double angle, double radius) {
		super((radius * 2 * Math.PI) / 360 * angle);
		
		this.angle = angle;
		this.radius = radius;
	}
	
	public BaseRail getConnectionB() {
		return connectionB;
	}
	
	public double getLength() {		
		return (radius * 2 * Math.PI) / 360 * angle;
	}

	@Override
	public void connect(BaseRail railToConnect) {
		if(this.connectionA == null) {
			this.connectionA = railToConnect;
		}
		
		else if(this.connectionB == null) {
			this.connectionB = railToConnect;
		}
		
		else {
			System.out.println("This rails connections are already used. You cant change these connections");
		}
	}
}