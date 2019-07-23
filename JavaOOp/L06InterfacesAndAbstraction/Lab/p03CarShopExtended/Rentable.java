package JavaOOP.L06InterfacesAndAbstraction.Lab.p03CarShopExtended;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
