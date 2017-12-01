package trackingsystem;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import trackingsystem.entities.Passenger;
import trackingsystem.entities.PassengerType;

public class TrackingSystem {
	List<Passenger> passengers;

	public TrackingSystem() {
		super();
		passengers = new LinkedList<>();
	}

	public final int getPaperCount() {
		int count = 0;
		for (Passenger p : passengers)
			count = p.hasNewsPaper() ? count + 1 : count;
		return count;
	}

	public final int getMealCount() {
		int count = 0;
		for (Passenger p : passengers)
			count += this.calcMeals(p);
		return count;
	}

	public final double getTotalFare() {
		BigDecimal fare = new BigDecimal(0);
		for (Passenger p : passengers)
			fare = fare.add(this.calcFare(p));
		return fare.doubleValue();
	}

	public final void addPassenger(Passenger p) {
		this.passengers.add(p);
	}

	private final int calcMeals(Passenger p) {
		if (p.getType().equals(PassengerType.Commuter))
			return 0;
		else {
			return (int) Math.ceil(p.getMiles() / 100.0);
		}
	}

	private final BigDecimal calcFare(Passenger p) {
		if (p.getType().equals(PassengerType.Commuter)) {
			return BigDecimal.valueOf(Passenger.RATE * p.getNumOfStops() * (p.hasFrequentRiderCard() ? 0.9 : 1.0));
		} else {
			return BigDecimal.valueOf(Passenger.RATE * p.getMiles());
		}
	}

}
