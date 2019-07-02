package JavaOOp.L04Inheritance.Exercises.p04NeedForSpeed;

public class SportCar extends Car {
    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(10);
    }
}
