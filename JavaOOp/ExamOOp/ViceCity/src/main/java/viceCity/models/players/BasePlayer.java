package viceCity.models.players;

import viceCity.common.ExceptionMessages;
import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;
    private boolean alive;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.alive = true;
        this.gunRepository = new GunRepository();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        //The takeLifePoints method decreases players' life points.
        //    • Player's life points should not drop below zero
        if (this.getLifePoints()-points<=0){
            this.setLifePoints(0);
            this.alive=false;
        }else{
            this.setLifePoints(this.getLifePoints()-points);
        }
        //todo move da e samo prez setara

    }

    private void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.PLAYER_NULL_USERNAME);
        }

        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints<0){
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }
}
