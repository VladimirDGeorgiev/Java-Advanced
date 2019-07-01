package JavaOOp.L04Inheritance.Lab.p03HierarchicalInheritance;

import JavaOOp.L04Inheritance.Lab.p02MultipleInheritance.Puppy;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
