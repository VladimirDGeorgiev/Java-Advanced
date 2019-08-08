package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.RaceRepository;
import motocrossWorldChampionship.repositories.RiderRepository;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EngineImpl implements Engine {

    @Override
    public void run() {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Repository<Rider> riderRepository = new RiderRepository();
        Repository<Motorcycle> motorcycleRepository = new MotorcycleRepository();
        Repository<Race> raceRepository = new RaceRepository();
        ChampionshipController championshipController = new ChampionshipControllerImpl(riderRepository,motorcycleRepository,raceRepository);
        while (true){
            String command ="";
            try {
                command = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] tokens = command.split("\\s+");
            try {
            switch (tokens[0]){
                case "CreateRider":
                    System.out.println(championshipController.createRider(tokens[1]));
                    break;
                case "CreateMotorcycle":
                    System.out.println(championshipController.createMotorcycle(tokens[1], tokens[2], Integer.parseInt(tokens[3])));
                    break;
                case "AddMotorcycleToRider":
                    System.out.println(championshipController.addMotorcycleToRider(tokens[1], tokens[2]));

                    break;
                case "AddRiderToRace":
                    System.out.println(championshipController.addRiderToRace(tokens[1], tokens[2]));

                    break;
                case "CreateRace":
                    System.out.println(championshipController.createRace(tokens[1], Integer.parseInt(tokens[2])));

                    break;
                case "StartRace":
                    System.out.println(championshipController.startRace(tokens[1]));

                    break;

                case "End" :
                    return;
                default:
                    break;
            }
        }catch (NullPointerException|IllegalArgumentException str){
                System.out.println(str.getMessage());
            }


        }


    }
}
