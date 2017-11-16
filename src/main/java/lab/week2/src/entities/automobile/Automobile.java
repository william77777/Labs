package lab.week2.src.entities.automobile;

import lab.week2.src.entities.Vehicle;

public abstract class Automobile extends Vehicle {
	private final String displayInfo = "%s by %s with VIN %s is available to rent in %s. This %s has a range of %d and only costs %.2f%n";
	private String color;
	private final String manufacturer;
	private boolean isLimitable, isRenewable;

	public Automobile(String vin, int range, double price, int code, double luxuryTax, String color,
			String manufacturer, boolean isLimitable, boolean isRenewable) {
		super(vin, range, price, code, luxuryTax);
		this.color = color;
		this.manufacturer = manufacturer;
		this.isLimitable = isLimitable;
		this.isRenewable = isRenewable;
	}

	public String getColor() {
		return color;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public boolean isLimitable() {
		return isLimitable;
	}

	public boolean isRenewable() {
		return isRenewable;
	}

	@Override
	public String getDisplayInfo() {
			return getDisplayInfo(this.getClass().getSimpleName(), this.getManufacturer(), this.getVin(), this.getColor(),
					this.isLimitable ? "beast" : "monster", this.getRange(), this.calculateCost());
	}

	public String getDisplayInfo(String carType, String manufacturer, String vin, String color, String descriptor,
			int range, double cost) {
		return String.format(displayInfo, carType, manufacturer, vin, color, descriptor, range, cost);
	}

	@Override
	public double calculateCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
