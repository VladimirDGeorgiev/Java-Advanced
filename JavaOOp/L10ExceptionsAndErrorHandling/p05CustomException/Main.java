package JavaOOP.L10ExceptionsAndErrorHandling.p05CustomException;

import jdk.jfr.StackTrace;

public class Main {
    public static void main(String[] args) {
        try {

            Student student = new Student("4havdar", "vgaasg@abv.bg");
        }catch (RuntimeException exp){
            System.out.println(exp.getMessage());
        }
    }


}
