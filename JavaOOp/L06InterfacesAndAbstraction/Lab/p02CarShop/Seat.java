package JavaOOP.L06InterfacesAndAbstraction.Lab.p02CarShop;

import java.io.Serializable;

public class Seat implements Car, Serializable {
   private String model;
   private String color;
   private String countryProduced;
   private Integer horsePower;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.countryProduced = countryProduced;
        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    public String getCountryProduced() {
        return countryProduced;
    }


    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires"
        ,this.model
        ,this.countryProduced
        , TIRES);
    }
}
