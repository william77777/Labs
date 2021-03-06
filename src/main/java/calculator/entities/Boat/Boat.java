package calculator.entities.Boat;

import java.math.BigDecimal;

import calculator.entities.Vehicle;
import calculator.entities.enums.BoatType;

public class Boat extends Vehicle {
	private final String displayInfo = "%s with VIN %s is available to rent. This beauty has a range of %,d and only costs $%,.2f";
	private final BoatType boatType;

	public Boat(long vin, int range, double price, int code, double luxuryTax, BoatType boatType) {
		super(vin, range, price, code, luxuryTax);
		this.boatType = boatType;
	}

	@Override
	public String getDisplayInfo() {
		return getDisplayInfo(getBoatTypeName(), this.getVin(), this.getRange(), this.calculateCost());
	}


	public String getDisplayInfo(double discount) {
		return getDisplayInfo(getBoatTypeName(), this.getVin(), this.getRange(),
				BigDecimal.valueOf(this.calculateCost() * (1 - discount)).doubleValue());
	}

	public String getDisplayInfo(String boatType, long l, int range, double cost) {
		return String.format(displayInfo, boatType, l, range, cost);
	}

	public final BoatType getBoatType() {
		return boatType;
	}

	private String getBoatTypeName() {
		String boatName = this.getBoatType().toString();
		boatName = boatName.charAt(0) + boatName.substring(1).toLowerCase();
		return boatName;
	}

}
