package JavaOOP.L06InterfacesAndAbstraction.Lab.p04SayHello;

public class European implements Person {
    private String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }


}
