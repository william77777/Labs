package calculator.entities.automobile;

import java.math.BigDecimal;

public class Diesal extends Automobile {

	private final int wheels;
	private final int cylinders;

	public Diesal(long vin, int range, double price, int code, double luxuryTax, String color, String manufacturer,
			boolean isLimitable, boolean isRenewable, int wheels, int cylinders) {
		super(vin, range, price, code, luxuryTax, color, manufacturer, isLimitable, isRenewable);
		this.wheels = wheels;
		this.cylinders = cylinders;
	}

	public final int getWheels() {
		return wheels;
	}

	public final int getCylinders() {
		return cylinders;
	}

	@Override
	public String getDisplayInfo() {
		return super.getDisplayInfo(this.isLimitable() ? "SemiTruck" : "Diesel", this.getManufacturer(), this.getVin(),
				this.getColor(), this.isLimitable() ? "monster" : "beast", this.getRange(), this.calculateCost());
	}

	@Override
	public String getDisplayInfo(double discount) {
		return super.getDisplayInfo(this.isLimitable() ? "SemiTruck" : "Diesel", this.getManufacturer(), this.getVin(),
				this.getColor(), this.isLimitable() ? "monster" : "beast", this.getRange(),
				BigDecimal.valueOf(this.calculateCost() * (1 - discount)).doubleValue());
	}

}
