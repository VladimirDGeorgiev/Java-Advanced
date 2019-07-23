package JavaOOP.L06InterfacesAndAbstraction.Lab.p04SayHello;

public interface Person {
    String getName();

    default String sayHello(){
       return "Hello";
    }
}
