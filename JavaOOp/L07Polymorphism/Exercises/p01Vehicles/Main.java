package JavaOOP.L07Polymorphism.Exercises.p01Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carData = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        String[] truckData = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] command = reader.readLine().split("\\s+");
            String commandType = command[0];
            String vehicleType = command[1];
            double number = Double.parseDouble(command[2]);

            switch (commandType) {
                case "Drive":
                    if (vehicleType.equals("Car")) {
                        System.out.println(car.driving(number));
                    } else {
                        System.out.println(truck.driving(number));
                    }
                    break;
                case "Refuel":
                    if (vehicleType.equals("Car")) {
                        car.refueling(number);
                    } else {
                        truck.refueling(number);
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
