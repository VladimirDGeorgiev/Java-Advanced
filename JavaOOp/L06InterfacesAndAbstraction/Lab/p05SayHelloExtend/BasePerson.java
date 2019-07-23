package JavaOOP.L06InterfacesAndAbstraction.Lab.p05SayHelloExtend;

public abstract class BasePerson implements Person {
    private String name;

    protected BasePerson(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
