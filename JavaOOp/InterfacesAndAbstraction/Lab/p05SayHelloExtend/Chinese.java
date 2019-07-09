package JavaOOP.L06InterfacesAndAbstraction.Lab.p05SayHelloExtend;

public class Chinese extends BasePerson {


    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
