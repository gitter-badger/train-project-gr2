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
	
	/**
	 * Constructor for a non-default trafo.
	 * @param inputVoltage
	 * @param outputVoltage
	 * @throws Exception
	 */
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

	/**
	 * @return the actual pace out of this trafo.
	 */
	public double getPace() {
		return pace;
	}

	/**
	 * @param pace
	 */
	public void setPace(double pace) {
		this.pace = pace;
	}
	
	/**
	 * @return if there is a shortcircuit on this trafo.
	 */
	public boolean getShortCircuit() {
		return isShortCircuit;
	}

	/**
	 * @param isShortCircuit
	 */
	public void setShortCircuit(boolean isShortCircuit) {
		this.isShortCircuit = isShortCircuit;
	}

	/**
	 * @return the input voltage at this trafo.
	 */
	public double getInputVoltage() {
		return inputVoltage;
	}
	
	/**
	 * @return the output voltage at this trafo.
	 */
	public double getOutputVoltage() {
		return outputVoltage;
	}
}
