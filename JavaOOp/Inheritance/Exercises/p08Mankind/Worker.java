package JavaOOp.L04Inheritance.Exercises.p08Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;


    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) throws IllegalArgumentException {
        if (weekSalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) throws IllegalArgumentException {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    public double SalaryPerHour() {
        return this.getWeekSalary() / (7 * this.getWorkHoursPerDay());
    }

    @Override
    public String toString() {
        return String.format("First Name: %s\n" +
                        "Last Name: %s\n" +
                        "Week Salary: %.2f\n" +
                        "Hours per day: %.2f\n" +
                        "Salary per hour: %.2f\n"
                , super.getFirstName()
                , super.getLastName()
                , this.weekSalary
                ,this.workHoursPerDay
                ,this.SalaryPerHour());
    }
}
