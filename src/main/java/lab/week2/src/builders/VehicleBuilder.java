package lab.week2.src.builders;

import java.time.LocalDate;

import lab.week2.src.OutOfVehicleRangeException;
import lab.week2.src.entities.Vehicle;
import lab.week2.src.entities.Boat.Boat;
import lab.week2.src.entities.automobile.Automobile;
import lab.week2.src.entities.automobile.Diesal;
import lab.week2.src.entities.automobile.Electric;
import lab.week2.src.entities.automobile.Standard;
import lab.week2.src.enums.AutomobileType;
import lab.week2.src.enums.BoatType;
import lab.week2.src.enums.VehicleType;

public class VehicleBuilder {

	// instance
	private Vehicle vehicle;

	// Vehicle values
	private String vin;
	private int range;
	private double price;
	private int code;
	private double luxuryTax;

	// Automobile values
	private String color = "black";
	private String manufacturer;

	// Automobile subclass values
	private int wheels;
	private int cylinders;
	private int batteries;
	private boolean isTesla;
	private LocalDate date;
	private int seats;

	// Boat values
	private BoatType boatType;

	public Vehicle build(VehicleType type) {

		if (type instanceof AutomobileType) {
			switch ((AutomobileType) type) {
			case DIESAL:
				vehicle = new Diesal(vin, range, price, code, luxuryTax, color, manufacturer, false, false, wheels,
						cylinders);
				break;
			case ELECTRIC:
				vehicle = new Electric(vin, range, price, code, luxuryTax, color, manufacturer, true, true, batteries,
						isTesla);
				break;
			case SEMIDIESAL:
				vehicle = new Diesal(vin, range, price, code, luxuryTax, color, manufacturer, true, false, wheels,
						cylinders);
				break;
			default: // STANDARD
				vehicle = new Standard(vin, range, price, code, luxuryTax, color, manufacturer, false, false, date,
						seats);
				break;
			}
			if (((Automobile) vehicle).isLimitable() && (range < 0 || range > 499)) {
				throw new OutOfVehicleRangeException(String.format(
						"Requested range %d is not within the applicable range of 0-499 for limitable vehicles.",
						range));
			}
		} else {
			vehicle = new Boat(vin, range, price, code, luxuryTax, boatType);
		}
		return vehicle;
	}

	public VehicleBuilder setVin(String vin) {
		this.vin = vin;
		return this;
	}

	public VehicleBuilder setRange(int range) {
		this.range = range;
		return this;
	}

	public VehicleBuilder setPrice(double price) {
		this.price = price;
		return this;
	}

	public VehicleBuilder setCode(int code) {
		this.code = code;
		return this;
	}

	public VehicleBuilder setColor(String color) {
		this.color = color;
		return this;
	}

	public VehicleBuilder setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		return this;
	}

	public VehicleBuilder setWheels(int wheels) {
		this.wheels = wheels;
		return this;
	}

	public VehicleBuilder setCylinders(int cylinders) {
		this.cylinders = cylinders;
		return this;
	}

	public VehicleBuilder setBatteries(int batteries) {
		this.batteries = batteries;
		return this;
	}

	public VehicleBuilder setTesla(boolean isTesla) {
		this.isTesla = isTesla;
		return this;
	}

	public VehicleBuilder setDate(LocalDate date) {
		this.date = date;
		return this;
	}

	public VehicleBuilder setSeats(int seats) {
		this.seats = seats;
		return this;
	}

	public VehicleBuilder setBoatType(BoatType boatType) {
		this.boatType = boatType;
		return this;
	}

	public VehicleBuilder setLuxuryTax(double luxuryTax) {
		this.luxuryTax = luxuryTax;
		return this;
	}

}
