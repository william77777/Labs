package lab.week2.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lab.week2.entities.Boat.Boat;
import lab.week2.exceptions.ZeroVehicleRangeException;

public abstract class Vehicle {
	private long vin;
	private int range;
	private double price;
	private int code;
	private double luxuryTax;

	public abstract String getDisplayInfo();

	/**
	 * Need to handle a range of zero
	 * 
	 * @return
	 */
	public double calculateCost() {
		if (this.range == 0) {
			if (this.getClass().equals((Boat.class))) {
				return 0.0; // boats should return a cost even when range is 0
			}
			throw new ZeroVehicleRangeException("Non-boat vehicles cannot have a range of 0.");
		} else {
			BigDecimal cost = BigDecimal.valueOf(this.getPrice());
			cost = cost.multiply(
						BigDecimal.valueOf(this.getVin())
						.divide(BigDecimal.valueOf(this.getCode()))
					)
					.divide(BigDecimal.valueOf(this.getRange()))
					.add(BigDecimal.valueOf(this.getLuxuryTax()))
					.setScale(2, RoundingMode.CEILING)
					;
			return Math.round(cost.doubleValue());
		}
	}

	public Vehicle(long vin, int range, double price, int code, double luxuryTax) {
		super();
		this.vin = vin;
		this.range = range;
		this.price = price;
		this.code = code;
		this.luxuryTax = luxuryTax;
	}

	public long getVin() {
		return vin;
	}

	public void setVin(long vin) {
		this.vin = vin;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getLuxuryTax() {
		return luxuryTax;
	}

	public void setLuxuryTax(double luxuryTax) {
		this.luxuryTax = luxuryTax;
	}

}
