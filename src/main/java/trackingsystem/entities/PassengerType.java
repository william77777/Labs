package trackingsystem.entities;

/**
 * A passenger can be a commuter or a vacationer
 * 
 * @author wums
 *
 */
public enum PassengerType {

	Commuter("Commuter"), Vacationer("Vacationer");

	private final String name;

	private PassengerType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
