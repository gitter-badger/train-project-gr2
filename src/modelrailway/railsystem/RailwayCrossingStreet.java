package modelrailway.railsystem;

/**
 * A crossing of a Railroad and a street
 * 
 * @author David Oberholzer
 * @version 1.0
 */
public class RailwayCrossingStreet extends StraightRail {

	/**
	 * it can has trafficLights
	 */
	private boolean trafficLights;
	
	/**
	 * can only be true when trafficLights is true
	 */
	private boolean trafficLightsActive;
	
	/**
	 * it can has warnSigns;
	 */
	private boolean warnSigns;
	
	/**
	 * can only be true when warnSigns is true
	 */
	private boolean warnSignsActive;
	
	/**
	 * it can has barriers
	 */
	private boolean barries;
	
	/**
	 * can only be true when barriers is true
	 */
	private boolean barriesActive;
	
	public RailwayCrossingStreet(BaseRail connectionA, BaseRail connectionB) {
		super(5.0,connectionA, connectionB);
		this.setConnectionB(connectionB);
		
	}
	
	/**
	 * @return the trafficLights
	 */
	public boolean isTrafficLights() {
		return trafficLights;
	}

	/**
	 * @param trafficLights the trafficLights to set
	 */
	public void setTrafficLights(boolean trafficLights) {
		this.trafficLights = trafficLights;
	}

	/**
	 * @return the trafficLightsActive
	 */
	public boolean isTrafficLightsActive() {
		return trafficLightsActive;
	}

	/**
	 * @param trafficLightsActive the trafficLightsActive to set
	 */
	public void setTrafficLightsActive(boolean trafficLightsActive) {
		this.trafficLightsActive = trafficLightsActive;
	}

	/**
	 * @return the warnSigns
	 */
	public boolean isWarnSigns() {
		return warnSigns;
	}

	/**
	 * @param warnSigns the warnSigns to set
	 */
	public void setWarnSigns(boolean warnSigns) {
		this.warnSigns = warnSigns;
	}

	/**
	 * @return the warnSignsActive
	 */
	public boolean isWarnSignsActive() {
		return warnSignsActive;
	}

	/**
	 * @param warnSignsActive the warnSignsActive to set
	 */
	public void setWarnSignsActive(boolean warnSignsActive) {
		this.warnSignsActive = warnSignsActive;
	}

	/**
	 * @return the barries
	 */
	public boolean isBarries() {
		return barries;
	}

	/**
	 * @param barries the barries to set
	 */
	public void setBarries(boolean barries) {
		this.barries = barries;
	}

	/**
	 * @return the barriesActive
	 */
	public boolean isBarriesActive() {
		return barriesActive;
	}

	/**
	 * @param barriesActive the barriesActive to set
	 */
	public void setBarriesActive(boolean barriesActive) {
		this.barriesActive = barriesActive;
	}

	/* Überschreibt die Methoden welche bereits von StraightRail geerbt werden.
	 * Müssen also nicht neu geschrieben werden.
	 * 
	 * 
	/**
	 * @param trailType the trailType to set
	 * /
	public void setTrailType(String trailType) {
		this.trailType = trailType;
	}

	/**
	 * @return the connectionA
	 * /
	public BaseRail getConnectionA() {
		return this.connectionA;
	}

	/**
	 * @param connectionA the connectionA to set
	 * /
	public void setConnectionA(BaseRail connectionA) {
		this.connectionA = connectionA;
	}

	/**
	 * @return the connectionB
	 * /
	public BaseRail getConnectionB() {
		return connectionB;
	}

	/**
	 * @param connectionB the connectionB to set
	 * /
	public void setConnectionB(BaseRail connectionB) {
		this.connectionB = connectionB;
	}
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
