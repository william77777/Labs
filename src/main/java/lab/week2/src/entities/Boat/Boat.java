package lab.week2.src.entities.Boat;

import lab.week2.src.entities.Vehicle;
import lab.week2.src.enums.BoatType;

public class Boat extends Vehicle {
	private final String displayInfo = "%s with VIN %s is available to rent. This beauty has a range of %d and only costs %.2f%n";
	private final BoatType boatType;

	public Boat(String vin, int range, double price, int code, double luxuryTax, BoatType boatType) {
		super(vin, range, price, code, luxuryTax);
		this.boatType = boatType;
	}

	@Override
	public String getDisplayInfo() {
		return getDisplayInfo(this.getClass().getSimpleName(), this.getVin(), this.getRange(), this.calculateCost());
	}

	public String getDisplayInfo(String boatType, String vin, int range, double cost) {
		return String.format(displayInfo, boatType, vin, range, cost);
	}

	public BoatType getBoatType() {
		return boatType;
	}

}
