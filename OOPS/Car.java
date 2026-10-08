package OOPS;

class test {
    public static void main(String[] args) {

        Car t1 = new Car(120, "red", "BMW");
        t1.displayInfo();
        t1.displaySpeed(20);

    }

}

public class Car {
    int speed;
    String colour;
    String brand;

    public Car(int speed, String colour, String brand) {
        this.speed = speed;
        this.colour = colour;
        this.brand = brand;
    }

    public void displayInfo() {
        System.out.print(speed + " /n " + colour + " /n " + brand);
    }

    public void displaySpeed(int incr) {
        speed = speed + incr;
        System.out.println(speed);
    }
}
