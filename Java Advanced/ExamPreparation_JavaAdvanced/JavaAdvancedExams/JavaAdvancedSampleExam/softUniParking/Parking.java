package softUniParking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {

    private Map<String, Car> cars;
    private static int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.cars = new HashMap<>();
    }

    public String addCar(Car car) {
        if (this.cars.size() == capacity) {
            return "Parking is full!";
        } else if (this.cars.containsKey(car.getRegistrationNumber())) {
            return "Car with that registration number, already exists!";
        }
        this.cars.put(car.getRegistrationNumber(), car);
        return "Successfully added new car " + car.getMake() + " " + car.getRegistrationNumber();
    }

    public String removeCar(String registrationNumber) {
        if (!this.cars.containsKey(registrationNumber)) {
            return "Car with that registration number, doesn't exists!";
        }
        this.cars.remove(registrationNumber);
        return "Successfully removed " + registrationNumber;
    }

    public Car getCar(String registrationNumber) {

        return this.cars.get(registrationNumber);

    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        for (String registrationNumber : registrationNumbers) {
            System.out.println(this.removeCar(registrationNumber));
        }
    }

    public int getCount(){
        return this.cars.size();
    }

}