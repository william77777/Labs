package calculator.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

import calculator.entities.Boat.Boat;

public abstract class Vehicle {
	private static final int PRECISION = 10;

	// class values
	private final long vin;
	private final int range;
	private final double price;
	private final int code;
	private final double luxuryTax;

	public abstract String getDisplayInfo();

	/**
	 * Need to handle a range of zero
	 * 
	 * @return
	 */
	public final double calculateCost() {
		if (this.getClass().equals((Boat.class))) {
			return calculateCost(BigDecimal.valueOf(this.getRange() == 0 ? 1.0 : this.getRange() / 7.0).doubleValue());
		} else {
			if (this.getRange() == 0)
				throw new IllegalArgumentException("Non-boat vehicles cannot have a range of 0.");
			return calculateCost(this.getRange());
		}
	}

	private final double calculateCost(double range) {
		return BigDecimal.valueOf(this.getPrice())
				.multiply(BigDecimal.valueOf(this.getVin()).divide(BigDecimal.valueOf(this.getCode()), PRECISION,
						RoundingMode.HALF_UP))
				.divide(BigDecimal.valueOf(range), PRECISION, RoundingMode.HALF_UP)
				.add(BigDecimal.valueOf(this.getLuxuryTax())).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	public Vehicle(long vin, int range, double price, int code, double luxuryTax) {
		super();
		this.vin = vin;
		this.range = range;
		this.price = price;
		this.code = code;
		this.luxuryTax = luxuryTax;
	}

	public final long getVin() {
		return vin;
	}

	public final int getRange() {
		return range;
	}

	public final double getPrice() {
		return price;
	}

	public final int getCode() {
		return code;
	}

	public final double getLuxuryTax() {
		return luxuryTax;
	}
}
