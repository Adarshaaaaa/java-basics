public class Car extends Vehicle{
    public Car(String id, String model, double dailyRate) {

        super(id, model, dailyRate);
    }
    @Override
    public double calculateRent(int days) {
        return dailyRate * days;
    }
}
