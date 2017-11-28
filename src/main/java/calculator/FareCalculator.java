package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

import calculator.entities.Vehicle;

public class FareCalculator {

	private final List<Vehicle> vehicles;

	public FareCalculator() {
		this.vehicles = new LinkedList<>();
	}
	
	public FareCalculator(List<Vehicle> vehicles) {
		this.vehicles = new LinkedList<>(vehicles);
	}

	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}

	public void clear() {
		this.vehicles.clear();
	}

	public double calculateGroupCost() {
		BigDecimal cost = BigDecimal.valueOf(0.0);
		for(Vehicle vehicle: this.vehicles) {
			cost = cost.add(BigDecimal.valueOf(vehicle.calculateCost()));
		}
		return cost.doubleValue();
	}
	
	public double calculateGroupCost(double discount) {
		if(discount > 1.0 || discount < 0.0)
			throw new IllegalArgumentException("Discount cannot be greater than 1.0 or less than 0.0");
		BigDecimal cost = BigDecimal.valueOf(0.0);
		for(Vehicle vehicle: this.vehicles) {
			cost = cost.add(BigDecimal.valueOf(vehicle.calculateCost()));
		}
		cost = cost.multiply(BigDecimal.valueOf(1.0-discount)).setScale(2, RoundingMode.HALF_UP);
		return cost.doubleValue();
	}
	
	public String displayVehiclesAndTotalCost() {
		StringBuilder display = new StringBuilder("");
		
		System.out.println("List of vehicles: ");
		for(Vehicle v: this.vehicles)
			display.append(v.getDisplayInfo()).append("\n");
		display.append(String.format("Total cost: %.2f%n", this.calculateGroupCost()));
		return display.toString();
	}
}
