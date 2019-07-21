package JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;


public class ReportCommand extends Command {
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = this.getRepository().getStatistics();
        return output;
    }
}
