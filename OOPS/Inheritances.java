package OOPS;

class vehicle {
    String Brand;

    void StartEngine() {
        System.out.println("Brand: " + Brand + " engine is started");
    }
}

class Bike extends vehicle {
    boolean hasCarrier;

    void kickStand() {
        System.out.println("kickstand put down ");
    }
}

class Inheritances {
    public static void main(String[] args) {
        Bike myBike = new Bike();
        myBike.Brand = "classic 350";
        System.out.println("Has carrier: " + myBike.hasCarrier);
        myBike.StartEngine();
        myBike.kickStand();
    }
}
