package models.players;

import common.ConstantMessages;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer( CardRepository cardRepository,String username, int health) {
        this.setUsername(username);
        this.setHealth(health);
        this.cardRepository = cardRepository;
        isDead=false;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints<0){
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }
        this.health=healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints<0){
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        int sum = this.getHealth()-damagePoints;
        if (sum<0){
            sum=0;
            this.setDead(true);
        }
        this.setHealth(sum);

    }

    private void setUsername(String username) {
        if (username==null||username.trim().isEmpty()){
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }

        this.username = username;
    }

    private void setDead(boolean dead) {
        this.isDead = dead;
    }

    @Override
    public String toString() {

        //"Username: {username} - Health: {health} – Cards {cards count}"
        //"Card: {name} - Damage: {card damage}"
        //"###"
        StringBuilder playerInfo = new StringBuilder();
        playerInfo.append(String.format(ConstantMessages.PLAYER_REPORT_INFO
                            ,this.getUsername()
                            ,this.getHealth()
                            ,this.getCardRepository().getCount()));
        playerInfo.append(System.lineSeparator());

        for (Card card : this.getCardRepository().getCards()) {
            playerInfo.append(card.toString()).append(System.lineSeparator());
        }
        return playerInfo.toString() + ConstantMessages.DEFAULT_REPORT_SEPARATOR;


    }
}
