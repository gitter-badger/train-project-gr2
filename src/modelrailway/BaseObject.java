package modelrailway;

import java.util.UUID;

/**
 * This class is taken as BaseObject, that means each class inherits from this class.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class BaseObject {
	private String id;
	
	protected BaseObject() {
		this.id = UUID.randomUUID().toString();
	}

	protected String getId() {
		return this.id;
	}	
}