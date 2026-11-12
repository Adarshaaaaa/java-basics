import java.util.ArrayList;

public class RentalShop {
    private ArrayList<Vehicle> fleet = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public Rental rent(String vehicleId, Customer customer, int days)
            throws Exception {

        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Rental days must be greater than zero");
        }

        Vehicle selected = null;

        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().equals(vehicleId)) {
                selected = vehicle;
                break;
            }
        }

        if (selected == null) {
            throw new Exception("Vehicle " + vehicleId + " not found");
        }

        if (!selected.isAvailable()) {
            throw new Exception(
                    selected.getDetails() + " is already rented");
        }

        Rental rental = new Rental(selected, customer, days);

        selected.setAvailable(false);
        customer.addRental(rental);

        System.out.printf(
                "%s rented %s for %d days = %.2f%n",
                customer.getName(),
                selected.getDetails(),
                days,
                rental.getTotalRent()
        );

        return rental;
    }

    public void giveBack(String vehicleId) throws Exception {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().equals(vehicleId)) {
                if (vehicle.isAvailable()) {
                    throw new Exception(
                            vehicle.getDetails() + " is not currently rented");
                }

                vehicle.setAvailable(true);
                return;
            }
        }

        throw new Exception("Vehicle " + vehicleId + " not found");
    }

    public void showAvailable() {
        System.out.println("Available vehicles:");

        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailable()) {
                System.out.println("  " + vehicle.getDetails());
            }
        }
    }
}
