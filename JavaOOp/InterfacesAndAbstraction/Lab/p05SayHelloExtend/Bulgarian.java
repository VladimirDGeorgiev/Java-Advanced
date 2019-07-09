package JavaOOP.L06InterfacesAndAbstraction.Lab.p05SayHelloExtend;

public class Bulgarian extends BasePerson {


    protected Bulgarian(String name) {
        super(name);
    }

    public String sayHello(){
      return "Здравей";
  }
}
