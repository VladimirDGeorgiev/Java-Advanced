package JavaOOP.L06InterfacesAndAbstraction.Lab.p03CarShopExtended;

import java.io.Serializable;

public class Seat implements Sellable, Serializable {
    private String model;
    private String color;
    private String countryProduced;
    private Integer horsePower;
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        this.model = model;
        this.color = color;
        this.countryProduced = countryProduced;
        this.horsePower = horsePower;
        this.price = price;
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
                , this.model
                , this.countryProduced
                , TIRES) + System.lineSeparator() +
                String.format("%s sells for %f",this.model,this.price);
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
