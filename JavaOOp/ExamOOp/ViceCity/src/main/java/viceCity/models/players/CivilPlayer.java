package viceCity.models.players;

import viceCity.models.players.BasePlayer;

public class CivilPlayer extends BasePlayer {

    private static final int INITIAL_LIFE_POINTS = 50;

    public CivilPlayer(String name) {
        super(name, INITIAL_LIFE_POINTS);
    }
}
