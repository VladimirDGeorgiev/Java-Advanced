package motocrossWorldChampionship.core;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.common.OutputMessages;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.RaceRepository;
import motocrossWorldChampionship.repositories.RiderRepository;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ChampionshipControllerImpl implements ChampionshipController {
    private Repository<Rider>       riderRepository;
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Race>        raceRepository;

    public ChampionshipControllerImpl( Repository<Rider> riderRepository ,
                                       Repository<Motorcycle> motorcycleRepository,
                                       Repository<Race> raceRepository
                                       ) {
        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createRider(String riderName) {

        if (this.riderRepository.getByName(riderName) == null) {
            this.riderRepository.add(new RiderImpl(riderName));
            return String.format(OutputMessages.RIDER_CREATED, riderName);
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_EXISTS, riderName));
        }

    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        Motorcycle motorcycle = null;
        if (type.equals("Speed")) {
            motorcycle = new SpeedMotorcycle(model, horsePower);
        } else if (type.equals("Power")) {
            motorcycle = new PowerMotorcycle(model, horsePower);
        }

        if (this.motorcycleRepository.getByName(model) == null) {
            this.motorcycleRepository.add(motorcycle);
            return String.format(OutputMessages.MOTORCYCLE_CREATED, type + "Motorcycle", model);
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.MOTORCYCLE_EXISTS, model));
        }

    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {

        if (this.riderRepository.getByName(riderName) == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }
        if (this.motorcycleRepository.getByName(motorcycleModel) == null) {
            throw new NullPointerException(String.format(ExceptionMessages.MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }

        this.riderRepository.getByName(riderName).addMotorcycle(this.motorcycleRepository.getByName(motorcycleModel));
        return String.format(OutputMessages.MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        if (this.raceRepository.getByName(raceName) == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (this.riderRepository.getByName(riderName) == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }
        if (this.riderRepository.getByName(riderName).getCanParticipate()) {

            this.raceRepository.getByName(raceName).addRider(this.riderRepository.getByName(riderName));
            return String.format(OutputMessages.RIDER_ADDED, riderName, raceName);
        } else {
            return String.format(ExceptionMessages.RIDER_NOT_PARTICIPATE, riderName);
        }
    }

    @Override
    public String startRace(String raceName) {
        if (this.raceRepository.getByName(raceName) == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (this.raceRepository.getByName(raceName).getRiders().size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }
        int currentLabs = this.raceRepository.getByName(raceName).getLaps();
        List<Rider> collect = this.raceRepository.getByName(raceName).getRiders()
                .stream()
                .sorted((f, s) -> Double.compare(s.getMotorcycle().calculateRacePoints(currentLabs), f.getMotorcycle().calculateRacePoints(currentLabs)))
                .limit(3)
                .collect(Collectors.toList());
        String result = "";
        for (int i = 0; i < collect.size(); i++) {
            Rider riderName = collect.get(i);

            if (i == 0) {
                result += String.format(OutputMessages.RIDER_FIRST_POSITION, riderName.getName(), raceName);
                result += System.lineSeparator();
            } else if (i == 1) {
                result += String.format(OutputMessages.RIDER_SECOND_POSITION, riderName.getName(), raceName);
                result += System.lineSeparator();
            } else if (i == 2) {
                result += String.format(OutputMessages.RIDER_THIRD_POSITION, riderName.getName(), raceName);
            }
        }
        return result;

    }

    @Override
    public String createRace(String name, int laps) {
        if (this.raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }
        Race race = new RaceImpl(name, laps);
        this.raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
