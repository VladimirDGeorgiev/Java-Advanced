package JavaOOP.L07Polymorphism.Exercises.p01Vehicles;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;


    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
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
        if(liters>0) {
            this.fuelQuantity += liters;
        }
    };



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
