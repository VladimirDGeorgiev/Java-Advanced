package JavaOOP.L10ExceptionsAndErrorHandling.p04ValidPerson;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Franko","Asen", 19);
        }catch (IllegalArgumentException exp){
            System.out.println("Exception thrown:"+exp.getMessage());
        }
        try {
            Person person1 = new Person(" ","Asen", 19);
        }catch (IllegalArgumentException exp){
            System.out.println("Exception thrown:"+exp.getMessage());
        }
        try {
            Person person2 = new Person("Franko",null, 19);
        }catch (IllegalArgumentException exp){
            System.out.println("Exception thrown:"+exp.getMessage());
        }
        try {
            Person person3 = new Person("Franko","Asen", -1);
        }catch (IllegalArgumentException exp){
            System.out.println("Exception thrown:"+exp.getMessage());
        }
        try {
            Person person4 = new Person("Franko","Asen", 121);
        }catch (IllegalArgumentException exp) {
            System.out.println("Exception thrown:" + exp.getMessage());
        }


    }
}
