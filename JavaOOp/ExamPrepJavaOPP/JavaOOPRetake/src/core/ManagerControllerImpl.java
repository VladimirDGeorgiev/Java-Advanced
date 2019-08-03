package core;

import common.ConstantMessages;
import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;


public class ManagerControllerImpl implements ManagerController {

    private CardRepository cardRepository;
    private PlayerRepository playerRepository;

    public ManagerControllerImpl() {
       this.cardRepository = new CardRepositoryImpl();
       this.playerRepository = new PlayerRepositoryImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;
        if (type.equals("Advanced")){
            player = new Advanced(new CardRepositoryImpl(),username);
        }else{
            player = new Beginner(new CardRepositoryImpl(),username);
        }
        this.playerRepository.add(player);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER,type,username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;
        if (type.equals("Trap")){
            card = new TrapCard(name);
        }else{
            card = new MagicCard(name);
        }
        this.cardRepository.add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD,type,name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Card card = this.cardRepository.find(cardName);
        this.playerRepository.find(username).getCardRepository().add(card);

        return  String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS,cardName,username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {

        Battlefield battlefield = new BattleFieldImpl();
        battlefield.fight(this.playerRepository.find(attackUser),this.playerRepository.find(enemyUser));

        return  String.format(ConstantMessages.FIGHT_INFO,this.playerRepository.find(attackUser).getHealth(),
                this.playerRepository.find(enemyUser).getHealth());
    }

    @Override
    public String report() {
        StringBuilder reportInfo = new StringBuilder();
        this.playerRepository.getPlayers().forEach(p->reportInfo.append(p.toString()).append(System.lineSeparator()));

        return reportInfo.toString().trim();
    }

    //todo Exit Command
    //Functionality
    //Terminate program.
}
