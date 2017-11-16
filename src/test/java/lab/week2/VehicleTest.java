package lab.week2;

import org.junit.BeforeClass;
import org.junit.Test;

import lab.week2.builders.VehicleBuilder;

public class VehicleTest {
	
	private static VehicleBuilder builder;
	
	@BeforeClass
	public static void setUp() {
		builder = new VehicleBuilder();
	}

	@Test
	public void when_calculateCost_return_double() {
		builder.setVin(100).setRange(200).setPrice(2000).setCode(21).setLuxuryTax(300);
	}
}
