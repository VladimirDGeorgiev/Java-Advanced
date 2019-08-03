package repositories;

import models.battleFields.BattleFieldImpl;
import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {


    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;

     //todo moje da trqbva da se promenq ne e QSNO
    }

    @Override
    public void add(Card card) {
        if (card==null){
            throw new IllegalArgumentException("Card cannot be null!");
        }
        if (this.cards.stream().anyMatch(e->e.getName().equals(card.getName()))) {
            throw new IllegalArgumentException("Card "+card.getName()+" already exists!");
        }
        this.cards.add(card);
    }

    @Override
    public boolean remove(Card card) {
        if (card==null){
            throw new IllegalArgumentException("Card cannot be null!");
        }
        return this.cards.removeIf(e->e.getName().equals(card.getName()));


        //todo premahvaneto na player move da e po ime ne po obekt!!!
    }

    @Override
    public Card find(String name) {
        Card card = null;
        for (Card card1 : this.cards) {
            if (card1.getName().equals(name)){
                card=card1;
            }
        }
        return card;
    }
}
