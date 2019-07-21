package JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command {
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {

        String typeOfUnit = getData()[1];

        try {

            getRepository().removeUnit(typeOfUnit);
            return typeOfUnit+" retired!";
        } catch (ExecutionControl.NotImplementedException e) {
           return e.getMessage();
        }
    }
}
