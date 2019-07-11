package JavaOOP.L07Polymorphism.Exercises.p02VehiclesExtension;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;


    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public  String driving(double distance){

        if (distance*this.fuelConsumption<this.fuelQuantity){
            NumberFormat format = new DecimalFormat("0.##");
            this.fuelQuantity-=distance*this.getFuelConsumption();
           return   String.format("%s travelled %s km",this.getClass().getSimpleName(),format.format(distance));

        }else{
            return String.format("%s needs refueling",this.getClass().getSimpleName());
        }
    };
    public void refueling(double liters){
        if (liters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (liters+this.getFuelQuantity()>this.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
            this.fuelQuantity += liters;

    };

    public double getTankCapacity() {
        return tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.getFuelQuantity());
    }
}
