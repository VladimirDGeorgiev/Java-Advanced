package JavaOOP.L10ExceptionsAndErrorHandling.p05CustomException;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.chars().anyMatch(c->!Character.isLetter(c))){
            throw new InvalidPersonNameException("Name does not allow any special character or numeric value");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
