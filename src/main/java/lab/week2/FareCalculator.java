package lab.week2;

import lab.week2.builders.VehicleBuilder;
import lab.week2.entities.Vehicle;
import lab.week2.entities.enums.AutomobileType;

public class FareCalculator {

	public static void main(String[] args) {
		VehicleBuilder builder = new VehicleBuilder();
		builder.setVin(1)
		.setBatteries(43)
		.setCode(34);
		Vehicle car = builder.build(AutomobileType.DIESAL);
		System.out.println(car.getDisplayInfo());
	}

}
