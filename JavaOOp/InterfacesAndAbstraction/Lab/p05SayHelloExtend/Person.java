package JavaOOP.L06InterfacesAndAbstraction.Lab.p05SayHelloExtend;

public interface Person {
    String getName();

    default String sayHello(){
       return "Hello";
    }
}
