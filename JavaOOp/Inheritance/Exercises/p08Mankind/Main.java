package JavaOOp.L04Inheritance.Exercises.p08Mankind;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {
        try {
            Scanner scanner = new Scanner(System.in);
            String[] studentData = scanner.nextLine().split("\\s+");
            String firstName = studentData[0];
            String lastName = studentData[1];
            String facultyNumber = studentData[2];

            Student student = new Student(firstName,lastName,facultyNumber);

            String[] workerData = scanner.nextLine().split("\\s+");
            firstName = workerData[0];
            lastName  = workerData[1];
            double salary = Double.parseDouble(workerData[2]);
            double workingHours = Double.parseDouble(workerData[3]);

            Worker worker = new Worker(firstName,lastName,salary,workingHours);
            System.out.println(student.toString());
            System.out.println(worker.toString());

        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
