package week2.builders;

import java.time.LocalDate;

import week2.entities.Vehicle;
import week2.entities.Boat.Boat;
import week2.entities.automobile.Automobile;
import week2.entities.automobile.Diesal;
import week2.entities.automobile.Electric;
import week2.entities.automobile.Standard;
import week2.entities.enums.AutomobileType;
import week2.entities.enums.BoatType;
import week2.entities.enums.VehicleType;
import week2.exceptions.OutOfVehicleRangeException;

public class VehicleBuilder {

	// instance
	private Vehicle vehicle;

	// Vehicle values
	private long vin;
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

	private VehicleType type;

	public VehicleBuilder() {
	}

	public VehicleBuilder(VehicleType type) {
		this.type = type;
	}

	public Vehicle build() {
		if(this.type == null)
			throw new NullPointerException("Vehicle type has not been set.");
		return this.build(this.type);
	}

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
			if (((Automobile) vehicle).isLimitable() && (range < 50 || range > 499)) {
				throw new OutOfVehicleRangeException(String.format(
						"Requested range %d is not within the applicable range of 50-499 for limitable vehicles.",
						range));
			}
		} else {
			this.setBoatType((BoatType) type);
			vehicle = new Boat(vin, range, price, code, luxuryTax, boatType);
		}
		return vehicle;
	}

	public VehicleBuilder setVin(long vin) {
		this.vin = vin;
		return this;
	}

	public VehicleBuilder setType(VehicleType type) {
		this.type = type;
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
