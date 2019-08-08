package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

public class PowerMotorcycle extends MotorcycleImpl {
    private static final double CUBIC_CENTIMETERS = 450;
    private static final int MIN_HORSEPOWER = 70;
    private static final int MAX_HORSEPOWER = 100;


    public PowerMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }


    @Override
    protected int getPowerMin() {
        return MIN_HORSEPOWER;
    }

    @Override
    protected int getPowerMax() {
        return MAX_HORSEPOWER;
    }
}
