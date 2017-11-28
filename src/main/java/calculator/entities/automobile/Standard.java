package calculator.entities.automobile;

import java.time.LocalDate;

public class Standard extends Automobile {

	private final LocalDate date;
	private final int seats;

	public Standard(long vin, int range, double price, int code, double luxuryTax, String color, String manufacturer,
			boolean isLimitable, boolean isRenewable, LocalDate date, int seats) {
		super(vin, range, price, code, luxuryTax, color, manufacturer, isLimitable, isRenewable);
		this.date = date;
		this.seats = seats;
	}

	public final LocalDate getDate() {
		return date;
	}

	public final int getSeats() {
		return seats;
	}

}
