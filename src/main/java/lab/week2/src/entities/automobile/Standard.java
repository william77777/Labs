package lab.week2.src.entities.automobile;

import java.time.LocalDate;

public class Standard extends Automobile {

	private LocalDate date;
	private int seats;

	public Standard(String vin, int range, double price, int code, double luxuryTax, String color, String manufacturer,
			boolean isLimitable, boolean isRenewable, LocalDate date, int seats) {
		super(vin, range, price, code, luxuryTax, color, manufacturer, isLimitable, isRenewable);
		this.date = date;
		this.seats = seats;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}
