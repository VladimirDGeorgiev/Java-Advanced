package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {


    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead()||enemyPlayer.isDead()){
            throw new IllegalArgumentException("Player is dead!");
        }

        if (attackPlayer.getClass().getSimpleName().equals("Beginner")){
            increaceHealth(attackPlayer );
        }
        if (enemyPlayer.getClass().getSimpleName().equals("Beginner")){
            increaceHealth(enemyPlayer);
        }
        addTheHealthToThePlayerFromTheDeck(attackPlayer);
        addTheHealthToThePlayerFromTheDeck(enemyPlayer);
        int dmgPointsAttackPlr = attackPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
        int dmgPointsEnemyPlr = enemyPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
        while (true){
            enemyPlayer.takeDamage(dmgPointsAttackPlr);
            if (enemyPlayer.isDead()){
                break;
            }
            attackPlayer.takeDamage(dmgPointsEnemyPlr);
            if (attackPlayer.isDead()){
                break;
            }
        }

    }

    private void addTheHealthToThePlayerFromTheDeck(Player player) {
        int sumOfCardHelth = player.getCardRepository().getCards().stream().mapToInt(Card::getHealthPoints).sum();
        player.setHealth(player.getHealth()+sumOfCardHelth);
    }

    private void increaceHealth(Player player) {
        player.setHealth(player.getHealth()+40);
        player.getCardRepository().getCards().forEach(card -> {
            card.setDamagePoints(card.getDamagePoints()+30);
        });
    }
}
