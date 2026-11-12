import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Rental> rentalHistory;

    public Customer(String name) {
        this.name = name;
        rentalHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentalHistory.add(rental);
    }

    public ArrayList<Rental> getRentalHistory() {
        return rentalHistory;
    }


}
