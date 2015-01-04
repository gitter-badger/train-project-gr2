package modelrailway.railsystem;

/**
 * A crossing of a Railroad and a street
 * 
 * @author David Oberholzer
 * @version 1.0
 */
public class RailwayCrossingStreet extends StraightRail {
	private boolean trafficLights;
	private boolean trafficLightsActive;
	private boolean warnSigns;
	private boolean warnSignsActive;
	private boolean barries;
	private boolean barriesActive;

	/**
	 * Constructor for a default railwaycrossingstreet.
	 */
	public RailwayCrossingStreet() {
		super(5.0);
		
		this.barries = true;
		this.trafficLights = true;
		this.warnSigns = false;
		
		this.barriesActive = false;
		this.trafficLightsActive = false;
		this.warnSignsActive = false;
	}
	
	/**
	 * Constructor for a non-default railwaycrossingstreet.
	 * @param length
	 * @param barries
	 * @param trafficLights
	 * @param warnSigns
	 */
	public RailwayCrossingStreet(double length, boolean barries, boolean trafficLights, boolean warnSigns) {
		super(length);
		
		this.barries = true;
		this.trafficLights = true;
		this.warnSigns = false;
		
	}
	
	/**
	 * Returns if this railwaycrossing has traffic lights.
	 * @return trafficLights
	 */
	public boolean hasTrafficLights() {
		return trafficLights;
	}

	/**
	 * Returns if this traffic lights are active.
	 * @return trafficLightsActive
	 */
	public boolean areTrafficLightsActive() {
		return trafficLightsActive;
	}

	/** 
	 * Returns if this railwaycrossing has warn signs.
	 * @return warnSigns
	 */
	public boolean hasWarnSigns() {
		return warnSigns;
	}

	/**
	 * Returns if this warn signs are active.
	 * @return warnSignsActive
	 */
	public boolean areWarnSignsActive() {
		return warnSignsActive;
	}

	/**
	 * Returns if this railwaycrossing has barries.
	 * @return the barries
	 */
	public boolean hasBarries() {
		return barries;
	}

	/**
	 * Returns if this barries are active.
	 * @return barriesActive
	 */
	public boolean areBarriesActive() {
		return barriesActive;
	}

	/**
	 * Closes this railwaycrossing for cars.
	 * @return true if it was successfull.
	 */
	public boolean close(){
		if(trafficLights){
			trafficLightsActive = false;
		}
		if(warnSigns){
			warnSignsActive = false;
		}
		if(barriesActive){
			barriesActive = false;
		}
		return true;
	}
	
	/**
	 * Opens this railwaycrossing for cars.
	 * @return
	 */
	public boolean open(){
		if(!trafficLights){
			trafficLightsActive = true;
		}
		if(!warnSigns){
			warnSignsActive = true;
		}
		if(!barriesActive){
			barriesActive = true;
		}
		return true;
	} 
}
