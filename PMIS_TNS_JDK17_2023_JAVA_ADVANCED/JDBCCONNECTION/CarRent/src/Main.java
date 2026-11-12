//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RentalShop shop = new RentalShop();

        Car car = new Car("C1", "Swift", 2000);
        Bike bike = new Bike("B1", "Activa", 400);
        Truck truck = new Truck("T1", "Tata Ace", 2500);

        shop.addVehicle(car);
        shop.addVehicle(bike);
        shop.addVehicle(truck);

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");

        try {
            shop.rent("B1", asha, 8);
            shop.rent("T1", ravi, 2);

            // Try to rent the same bike again
            try {
                shop.rent("B1", ravi, 3);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Return the truck
            shop.giveBack("T1");

            shop.showAvailable();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}