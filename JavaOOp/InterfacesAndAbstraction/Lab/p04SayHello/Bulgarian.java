package JavaOOP.L06InterfacesAndAbstraction.Lab.p04SayHello;

public class Bulgarian implements Person {
    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String sayHello(){
        return "Здравей";
    }
}
