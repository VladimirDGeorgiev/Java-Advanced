package JavaOOP.L07Polymorphism.Exercises.p02VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carData = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1])
                , Double.parseDouble(carData[2])
                , Double.parseDouble(carData[3]));

        String[] truckData = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1])
                , Double.parseDouble(truckData[2])
                , Double.parseDouble(truckData[3]));

        String[] busData = reader.readLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busData[1])
                , Double.parseDouble(busData[2])
                , Double.parseDouble(busData[3]));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] command = reader.readLine().split("\\s+");
            String commandType = command[0];
            String vehicleType = command[1];
            double number = Double.parseDouble(command[2]);
            try {
                switch (commandType) {
                    case "Drive":
                        if (vehicleType.equals("Car")) {
                            System.out.println(car.driving(number));
                        } else if (vehicleType.equals("Truck")){
                            System.out.println(truck.driving(number));
                        }else{
                            System.out.println(bus.drivingWithPeople(number));
                        }
                        break;
                    case "Refuel":
                        if (vehicleType.equals("Car")) {
                            car.refueling(number);
                        } else if (vehicleType.equals("Truck")){
                            truck.refueling(number);
                        }else{
                            bus.refueling(number);
                        }
                        break;
                    case "DriveEmpty":
                        if (vehicleType.equals("Bus")) {
                            System.out.println(bus.driving(number));
                        }
                        break;
                    default:
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
