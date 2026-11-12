
    class Truck extends Vehicle {
        private static final double INSURANCE_CHARGE = 500.0;

        public Truck(String id, String model, double dailyRate) {
            super(id, model, dailyRate);
        }

        @Override
        public double calculateRent(int days) {
            return (dailyRate * days) + INSURANCE_CHARGE;
        }
    }