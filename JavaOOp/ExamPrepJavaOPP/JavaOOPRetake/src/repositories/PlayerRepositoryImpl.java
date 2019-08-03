package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {

    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;

        //todo moje da trqbva da se promenq ne e QSNO
    }

    @Override
    public void add(Player player) {
        if (player==null){
            throw new IllegalArgumentException("Player cannot be null!");
        }
        if (this.players.stream().anyMatch(e->e.getUsername().equals(player.getUsername()))) {
            throw new IllegalArgumentException("Player "+player.getUsername()+" already exists!");
        }
        this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        if (player==null){
            throw new IllegalArgumentException("Player cannot be null!");
        }
        return this.players.removeIf(e->e.getUsername().equals(player.getUsername()));

        //todo premahvaneto na player move da e po ime ne po obekt!!!
    }

    @Override
    public Player find(String name) {
        Player player = null;
        for (Player player1 : this.players) {
            if (player1.getUsername().equals(name)){
                player=player1;
            }
        }
        return player;
    }
}
