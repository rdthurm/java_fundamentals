package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<Card> cards;
    ArrayList<Integer> usedCards;

    public Deck(){
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"♠", "♦", "♥", "♣"};
        this.cards = new ArrayList<Card>();
        int idCounter = 0;
        for (String value : values) {
            for (String suit : suits) {
                this.cards.add(new Card(value, suit, idCounter));
                idCounter++;
            }
        }
        this.usedCards = new ArrayList<Integer>();
    }

    public void dealBlackjack(Player player) {
        //Deals one card to player
        boolean done = false;
        Random rand = new Random();

        while (!done) {
            int randIndex = rand.nextInt(52);
            if (!this.usedCards.contains(randIndex)){
                player.hand.dealtCards.add(this.cards.get(randIndex));
                this.cards.remove(randIndex);
                done = true;
            }
        }
    }

    public void dealSeven(ArrayList<SevenComputerPlayer> players) {
        //Deals whole deck out to players
        Card joker = new Card("Joker");
        this.cards.add(joker);
        Random rand = new Random();
        while (this.cards.size() > 0) {
            for (int i = 0; i < players.size(); i++) {
                int randIndex = rand.nextInt(this.cards.size());
                players.get(i).hand.dealtCards.add(this.cards.get(randIndex));
                SevenGameBoard.cardBank.add(this.cards.get(randIndex));
                this.cards.remove(randIndex);
                if (this.cards.size() == 0) break;
            }
        }
        for (SevenPlayer player : players) {
            player.hand.splitBySuits();
        }
    }


}
