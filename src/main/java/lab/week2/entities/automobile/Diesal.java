package lab.week2.entities.automobile;

public class Diesal extends Automobile {

	private final int wheels;
	private final int cylinders;

	public Diesal(long vin, int range, double price, int code, double luxuryTax, String color, String manufacturer,
			boolean isLimitable, boolean isRenewable, int wheels, int cylinders) {
		super(vin, range, price, code, luxuryTax, color, manufacturer, isLimitable, isRenewable);
		this.wheels = wheels;
		this.cylinders = cylinders;
	}

	public int getWheels() {
		return wheels;
	}

	public int getCylinders() {
		return cylinders;
	}

}
