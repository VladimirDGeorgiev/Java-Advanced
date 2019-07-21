package JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.core;

import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Executable;
import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Runnable;
import JavaOOP.L09ReflectionAndAnnotations.Exercises.p04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException | IOException | ExecutionControl.NotImplementedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
		String result ;
			commandName = commandName.toUpperCase().charAt(0)+commandName.substring(1)+"Command";
		try {
			Class typeOfCommand = Class.forName("barracksWars.core.commands."+commandName);
			Executable command = (Executable) typeOfCommand.getConstructor(String[].class, Repository.class, UnitFactory.class).newInstance(data,this.repository,this.unitFactory);
			return command.execute();
		} catch (ClassNotFoundException | InstantiationException |NoSuchMethodException | InvocationTargetException| IllegalAccessException e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

}
