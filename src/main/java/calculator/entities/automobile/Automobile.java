package calculator.entities.automobile;

import java.math.BigDecimal;

import calculator.entities.Vehicle;

public abstract class Automobile extends Vehicle {
	private final String displayInfo = "%s by %s with VIN %s is available to rent in %s. This %s has a range of %,d and only costs $%,.2f%s";
	private final String color;
	private final String manufacturer;
	private final boolean isLimitable, isRenewable;

	public Automobile(long vin, int range, double price, int code, double luxuryTax, String color, String manufacturer,
			boolean isLimitable, boolean isRenewable) {
		super(vin, range, price, code, luxuryTax);
		this.color = color;
		this.manufacturer = manufacturer;
		this.isLimitable = isLimitable;
		this.isRenewable = isRenewable;
	}

	public final String getColor() {
		return color;
	}

	public final String getManufacturer() {
		return manufacturer;
	}

	public final boolean isLimitable() {
		return isLimitable;
	}

	public final boolean isRenewable() {
		return isRenewable;
	}

	@Override
	public String getDisplayInfo() {
		return getDisplayInfo(this.getClass().getSimpleName(), this.getManufacturer(), this.getVin(), this.getColor(),
				this.isLimitable ? "monster" : "beast", this.getRange(), this.calculateCost());
	}
	
	public String getDisplayInfo(double discount) {
		return getDisplayInfo(this.getClass().getSimpleName(), this.getManufacturer(), this.getVin(), this.getColor(),
				this.isLimitable ? "monster" : "beast", this.getRange(), BigDecimal.valueOf(this.calculateCost()*(1-discount)).doubleValue());
	}

	public String getDisplayInfo(String carType, String manufacturer, long l, String color, String descriptor,
			int range, double cost) {
		return String.format(displayInfo, carType, manufacturer, l, color, descriptor, range, cost,
				this.isLimitable ? " unless range exceeded" : "");
	}

}
