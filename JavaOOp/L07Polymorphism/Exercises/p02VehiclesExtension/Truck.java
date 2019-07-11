package JavaOOP.L07Polymorphism.Exercises.p02VehiclesExtension;

public class Truck extends Vehicle {
    private final static double AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void refueling(double liters) {
        if (liters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (liters+this.getFuelQuantity()>this.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
            this.setFuelQuantity(this.getFuelQuantity() + liters * 0.95);

    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption+AIR_CONDITIONER_CONSUMPTION);
    }
}
