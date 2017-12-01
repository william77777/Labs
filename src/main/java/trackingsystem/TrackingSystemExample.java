package trackingsystem;
import trackingsystem.entities.Passenger;
import trackingsystem.entities.PassengerType;

public class TrackingSystemExample {
	public static void main(String[] args) {
		TrackingSystem system = new TrackingSystem();
		system.addPassenger(new Passenger(PassengerType.Commuter, 0, 3, false, true));
		system.addPassenger(new Passenger(PassengerType.Commuter, 0, 5, false, true));
		system.addPassenger(new Passenger(PassengerType.Commuter, 0, 4, true, false));
		system.addPassenger(new Passenger(PassengerType.Vacationer, 90, 0, false));
		system.addPassenger(new Passenger(PassengerType.Vacationer, 199, 0, true));
		System.out.printf("Newspapers: %d%nMeals: %d%nTotal Fare: %,.2f%n", system.getPaperCount(),
				system.getMealCount(), system.getTotalFare());
	}
}
