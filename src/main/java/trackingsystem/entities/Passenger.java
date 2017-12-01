package trackingsystem.entities;

import java.math.BigDecimal;

/**
 * Entity to represent a passenger
 * 
 * @author wums
 *
 */
public class Passenger {
	private PassengerType type;
	private int miles;
	private int numOfStops;
	private boolean hasNewspaper;
	private boolean hasFrequentRiderCard;
	public static final double RATE = BigDecimal.valueOf(0.5).doubleValue();

	public Passenger() {
	}

	public Passenger(PassengerType type, int miles, int numOfStops, boolean requestedNewspaper) {
		super();
		if (type.equals(PassengerType.Vacationer) && (miles < 5 || miles > 4000))
			throw new IllegalArgumentException("Vacationers cannot travel less than 5 or more than 4000 miles");
		this.type = type;
		this.miles = miles;
		this.numOfStops = numOfStops;
		this.hasNewspaper = requestedNewspaper;
	}

	public Passenger(PassengerType type, int miles, int numOfStops, boolean hasNewspaper,
			boolean hasFrequentRiderCard) {
		this(type, miles, numOfStops, hasNewspaper);
		this.hasFrequentRiderCard = hasFrequentRiderCard;
	}

	public final PassengerType getType() {
		return type;
	}

	public final void setType(PassengerType type) {
		this.type = type;
	}

	public final int getMiles() {
		return miles;
	}

	public final void setMiles(int miles) {
		if (this.getType().equals(PassengerType.Vacationer) && (miles < 5 || miles > 4000))
			throw new IllegalArgumentException("Vacationers cannot travel less than 5 or more than 4000 miles");
		this.miles = miles;
	}

	public final int getNumOfStops() {
		return numOfStops;
	}

	public final void setNumOfStops(int numOfStops) {
		this.numOfStops = numOfStops;
	}

	public final boolean hasNewsPaper() {
		return hasNewspaper;
	}

	public final void setHasNewspaper(boolean hasNewspaper) {
		this.hasNewspaper = hasNewspaper;
	}

	public final boolean hasFrequentRiderCard() {
		return hasFrequentRiderCard;
	}

	public final void setHasFrequentRiderCard(boolean hasFrequentRiderCard) {
		this.hasFrequentRiderCard = hasFrequentRiderCard;
	}

}
