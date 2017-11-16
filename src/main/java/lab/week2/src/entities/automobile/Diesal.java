package lab.week2.src.entities.automobile;

public class Diesal extends Automobile {

	private int wheels;
	private int cylinders;

	public Diesal(String vin, int range, double price, int code, double luxuryTax, String color, String manufacturer,
			boolean isLimitable, boolean isRenewable, int wheels, int cylinders) {
		super(vin, range, price, code, luxuryTax, color, manufacturer, isLimitable, isRenewable);
		this.wheels = wheels;
		this.cylinders = cylinders;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}

}
