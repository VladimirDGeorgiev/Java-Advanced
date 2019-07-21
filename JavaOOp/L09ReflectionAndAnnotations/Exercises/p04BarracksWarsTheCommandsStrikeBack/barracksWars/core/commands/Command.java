package JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Executable;
import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data,
                   Repository repository,
                   UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String[] getData() {
        return data;
    }

    public Repository getRepository() {
        return repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
