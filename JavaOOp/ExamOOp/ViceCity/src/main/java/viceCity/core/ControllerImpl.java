package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.*;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Collection<Player> civilPlayer;
    private Repository<Gun> gunRepository;
    private ArrayDeque<Gun> queue;
    private Neighbourhood fight;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayer = new ArrayList<>();
        this.gunRepository = new GunRepository();
        this.queue = new ArrayDeque<>();
        this.fight = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.civilPlayer.add(player);
        return String.format(ConstantMessages.PLAYER_ADDED,name);

    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        if (type.equals("Pistol")){
            gun = new Pistol(name);
        }else if(type.equals("Rifle")){
            gun = new Rifle(name);
        }else{
            return ConstantMessages.GUN_TYPE_INVALID;
        }
        this.gunRepository.add(gun);
        this.queue.add(gun);

        return String.format(ConstantMessages.GUN_ADDED,name,type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (this.gunRepository.getModels().size()==0){
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        if (name.equals("Vercetti")){
            Gun gun = this.queue.remove();
            this.mainPlayer.getGunRepository().add(gun);
            this.gunRepository.remove(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER,gun.getName(),"Tommy Vercetti");
        }
        if (this.civilPlayer.stream().noneMatch(e->e.getName().equals(name))){
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        Gun gun = this.queue.remove();
        this.gunRepository.remove(gun);

        this.civilPlayer.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null).getGunRepository().add(gun);
        this.gunRepository.remove(gun);

        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER,gun.getName(),name);
    }

    @Override
    public String fight() {
        int currentLifePointsOfTheMainPlayer = this.mainPlayer.getLifePoints();
        int sumLifePointsCivilPlayers = this.civilPlayer.stream().mapToInt(Player::getLifePoints).sum();

        this.fight.action(this.mainPlayer,this.civilPlayer);

        if (this.mainPlayer.getLifePoints()==currentLifePointsOfTheMainPlayer&&
        this.civilPlayer.stream().mapToInt(Player::getLifePoints).sum()==sumLifePointsCivilPlayers){
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        }

        long countOfDeadPlayers = this.civilPlayer.stream().filter(e->!e.isAlive()).count();
        long countOfALivePlayers = this.civilPlayer.stream().filter(Player::isAlive).count();
        this.civilPlayer.removeIf(e->!e.isAlive());

            StringBuilder result = new StringBuilder();
        result.append(FIGHT_HAPPENED).append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,this.mainPlayer.getLifePoints())).append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,countOfDeadPlayers)).append(System.lineSeparator())
                .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE,countOfALivePlayers));
        return result.toString();


    }
}
