package trackingsystem;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import trackingsystem.entities.Passenger;
import trackingsystem.entities.PassengerType;

public class TrackingSystemTest {
	private static final double DIFF = 0.001;
	private TrackingSystem system;

	@Before
	public void init() {
		this.system = new TrackingSystem();
	}

	@Test
	public void test_getPaperCount() {
		this.system.addPassenger(new Passenger(PassengerType.Commuter, 0, 10, true));
		this.system.addPassenger(new Passenger(PassengerType.Commuter, 0, 10, false));
		this.system.addPassenger(new Passenger(PassengerType.Commuter, 0, 10, true));
		Assert.assertEquals(2, system.getPaperCount());
	}

	@Test
	public void test_getMealCount() {
		this.system.addPassenger(new Passenger(PassengerType.Commuter, 100, 10, true));
		this.system.addPassenger(new Passenger(PassengerType.Vacationer, 185, 10, false));
		this.system.addPassenger(new Passenger(PassengerType.Vacationer, 246, 10, true));
		Assert.assertEquals(5, system.getMealCount());
	}

	@Test
	public void test_getTotalFare() {
		// Commuter with a frequent rider card
		Passenger p = new Passenger(PassengerType.Commuter, 50, 10, true, true);
		this.system.addPassenger(p);
		double currentFare = BigDecimal.valueOf(Passenger.RATE * 0.9 * p.getNumOfStops()).doubleValue();
		Assert.assertEquals(currentFare, system.getTotalFare(), DIFF);

		// Vacationer
		p = new Passenger(PassengerType.Vacationer, 50, 10, true, true);
		this.system.addPassenger(p);
		currentFare = BigDecimal.valueOf(currentFare + Passenger.RATE * p.getMiles()).doubleValue();
		Assert.assertEquals(currentFare, system.getTotalFare(), DIFF);

		// Commuter with a frequent rider card
		p = new Passenger(PassengerType.Commuter, 50, 10, true, false);
		this.system.addPassenger(p);
		currentFare = BigDecimal.valueOf(currentFare + Passenger.RATE * 1.0 * p.getNumOfStops()).doubleValue();
		Assert.assertEquals(currentFare, system.getTotalFare(), DIFF);
	}
}
