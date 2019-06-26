package softUniParking;

public class Car {

    private String make;
    private String model;
    private int horsePower;
    private String registrationNumber;

    public Car(String make, String model, int horsePower, String registrationNumber) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Make: ").append(this.make).append("\n")
                .append("Model: ").append(this.model).append("\n")
                .append("HorsePower: ").append(this.horsePower).append("\n")
                .append("RegistrationNumber: ").append(this.registrationNumber).toString().trim();
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

}
