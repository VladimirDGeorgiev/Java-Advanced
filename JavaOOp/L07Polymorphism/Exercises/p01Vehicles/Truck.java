package JavaOOP.L07Polymorphism.Exercises.p01Vehicles;

public class Truck extends Vehicle {
    private final static double AIR_CONDITIONER_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void refueling(double liters) {
        if (liters>0) {
            this.setFuelQuantity(this.getFuelQuantity() + liters * 0.95);
        }
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption+AIR_CONDITIONER_CONSUMPTION);
    }
}
