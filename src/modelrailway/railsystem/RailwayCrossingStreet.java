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
	private boolean barriers;
	private boolean barriersActive;

	/**
	 * Constructor for a default railwaycrossingstreet.
	 */
	public RailwayCrossingStreet() {
		super(5.0);
		
		this.barriers = true;
		this.trafficLights = true;
		this.warnSigns = false;
		
		this.barriersActive = false;
		this.trafficLightsActive = false;
		this.warnSignsActive = false;
	}
	
	/**
	 * Constructor for a non-default railwaycrossingstreet.
	 * @param length
	 * @param barriers
	 * @param trafficLights
	 * @param warnSigns
	 */
	public RailwayCrossingStreet(double length, boolean barriers, boolean trafficLights, boolean warnSigns) {
		super(length);
		
		this.barriers = barriers;
		this.trafficLights = trafficLights;
		this.warnSigns = warnSigns;
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
	 * Returns if this railwaycrossing has barriers.
	 * @return the barriers
	 */
	public boolean hasBarriers() {
		return barriers;
	}

	/**
	 * Returns if this barriers are active.
	 * @return barriersActive
	 */
	public boolean areBarriersActive() {
		return barriersActive;
	}

	/**
	 * Closes this railwaycrossing for cars.
	 * @return true if it was successfull.
	 */
	public boolean close(){
		if(trafficLights){
			trafficLightsActive = true;
		}
		if(warnSigns){
			warnSignsActive = true;
		}
		if(barriers){
			barriersActive = true;
		}
		return true;
	}
	
	/**
	 * Opens this railwaycrossing for cars.
	 * @return
	 */
	public boolean open(){
		if(!trafficLights){
			trafficLightsActive = false;
		}
		if(!warnSigns){
			warnSignsActive = false;
		}
		if(!barriers){
			barriersActive = false;
		}
		return true;
	} 
}
