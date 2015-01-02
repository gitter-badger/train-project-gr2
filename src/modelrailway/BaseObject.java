package modelrailway;

import java.util.UUID;

import modelrailway.railsystem.BaseRail;

/**
 * This class is taken as BaseObject, that means each class inherits from this class.
 * 
 * @author Simon Styger
 * @version 1.0
 */

public class BaseObject {
	private String id;
	
	/**
	 * Constructor for each object in this modelrailway, creates an id for each object
	 */
	protected BaseObject() {
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * Returns id of this object
	 * @return id
	 */
	protected String getId() {
		return this.id;
	}
}