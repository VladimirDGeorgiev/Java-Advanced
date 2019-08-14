package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

    public GangNeighbourhood() {
    }

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        //The main player starts shooting
        //    • He takes a gun from his guns.
        //    • Every time he shoots, he takes life points from the civil player, which are equal to the bullets that the
        //      current gun shoots when the trigger is pulled.
        //    • If the barrel of his gun becomes empty, he reloads from his bullets stock and continues shooting with the
        //      current gun, until he uses all of its bullets.
        //    • If his gun runs out of total bullets, he takes the next gun he has and continues shooting.
        //    • He shoots at the current civil player until he / she is alive.
        //    • If the civil player dies, he starts shooting at the next one.
        //    • The main player stops shooting only if he runs out of guns or until all the civil players are dead.
        ArrayDeque<Gun> mainPlayerGuns = new ArrayDeque<>(mainPlayer.getGunRepository().getModels());
        for (Player civilPlayer : civilPlayers) {
            while (true) {
                if (!civilPlayer.isAlive()) {
                    break;
                }
                if (mainPlayerGuns.isEmpty()) {
                    break;
                }
                Gun gun = mainPlayerGuns.peek();
                while (gun.canFire()) {
                    civilPlayer.takeLifePoints(gun.fire());
                    if (!gun.canFire()){
                        mainPlayerGuns.remove();
                    }
                    if (!civilPlayer.isAlive()){
                        break;
                    }

                }
            }
            if (mainPlayerGuns.isEmpty()) {
                break;
            }
        }


       // while (mainPlayer.isAlive()&&
      //          civilPlayers.stream().filter(e->e.getGunRepository().getModels().isEmpty()).count()==civilPlayers.size()){

            for (Player civilPlayer : civilPlayers) {
                for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                    while (gun.canFire()){
                        mainPlayer.takeLifePoints(gun.fire());
                        if (!mainPlayer.isAlive()) {
                            return;
                        }
                    }
                }
            }


       // }

    }
}
