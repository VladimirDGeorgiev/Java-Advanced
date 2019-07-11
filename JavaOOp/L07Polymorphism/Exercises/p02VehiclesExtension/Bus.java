package JavaOOP.L07Polymorphism.Exercises.p02VehiclesExtension;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Bus extends Vehicle {
    private final static double AIR_CONDITIONER_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }


    public String drivingWithPeople(double distance) {
        if (distance*this.getFuelConsumption()+AIR_CONDITIONER_CONSUMPTION<this.getFuelQuantity()){
            NumberFormat format = new DecimalFormat("0.##");
            this.setFuelQuantity(this.getFuelQuantity()-distance*(this.getFuelConsumption()+AIR_CONDITIONER_CONSUMPTION));
            return   String.format("%s travelled %s km",this.getClass().getSimpleName(),format.format(distance));

        }else{
            return String.format("%s needs refueling",this.getClass().getSimpleName());
        }
    }
}
