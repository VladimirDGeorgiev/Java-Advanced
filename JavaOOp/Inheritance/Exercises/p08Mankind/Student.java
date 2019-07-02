package JavaOOp.L04Inheritance.Exercises.p08Mankind;

public class Student extends Human{
    private String facultyNumber;

    public Student(String firstName, String lastName,String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) throws IllegalArgumentException{
        if (facultyNumber.length()<5||facultyNumber.length()>10){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s\n" +
                        "Last Name: %s\n"+
                        "Faculty number: %s"
                ,super.getFirstName()
                ,super.getLastName()
                ,this.facultyNumber);

    }
}
