package modelrailway.railsystem;

import modelrailway.BaseObject;

/**
 * This class describes a trafo that provides the power for each railsystem.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class Trafo extends BaseObject {
	private double inputVoltage;
	private double outputVoltage;
	private boolean isShortCircuit;
	private double pace;
	
	/**
	 * Constructor for a default trafo.
	 */
	Trafo() {
		super();
		
		this.inputVoltage = 240.0;
		this.outputVoltage = 3.5;
		
		this.isShortCircuit = false;
		this.setPace(0.0);
	}
	
	Trafo(double inputVoltage, double outputVoltage) throws Exception {		
		this.isShortCircuit = false;
		this.setPace(0.0);
		
		if(inputVoltage > outputVoltage) {
			this.inputVoltage = inputVoltage;
			this.outputVoltage = outputVoltage;			
		}
		else {			
			this.inputVoltage = 240.0;
			this.outputVoltage = 3.5;			
			throw new Exception("Outputvoltage can't be bigger than the inputvoltage.");
		}
	}

	public double getPace() {
		return pace;
	}

	public void setPace(double pace) {
		this.pace = pace;
	}
	
	public boolean getShortCircuit() {
		return isShortCircuit;
	}

	public void setShortCircuit(boolean isShortCircuit) {
		this.isShortCircuit = isShortCircuit;
	} 
}
