package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;

public abstract class MotorcycleImpl implements Motorcycle {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public MotorcycleImpl(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }
    protected abstract int getPowerMin();
    protected abstract int getPowerMax();

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters()/this.getHorsePower()*laps;
    }

    private void setModel(String model) {
        if (model==null||model.trim().isEmpty()||model.length()<4){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL,model,4));
        }
        this.model = model;
    }

    private void setHorsePower(int horsePower) {
        if (horsePower<this.getPowerMin()||horsePower>this.getPowerMax()){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
        }

        this.horsePower = horsePower;
    }
}
