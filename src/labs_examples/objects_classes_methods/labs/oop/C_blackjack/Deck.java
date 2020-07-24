package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    Card[] cards;
    ArrayList<Integer> usedCards;

    public Deck(){
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"♠", "♦", "♥", "♣"};
        cards = new Card[52];
        int counter = 0;
        for (String value : values) {
            for (String suit : suits) {
                cards[counter] = new Card(value, suit);
                counter++;
            }
        }
        this.usedCards = new ArrayList<Integer>();
    }

    public void deal(Player player) {
        boolean done = false;
        Random rand = new Random();

        while (!done) {
            int randIndex = rand.nextInt(52);
            if (!this.usedCards.contains(randIndex)){
                player.hand.cards.add(this.cards[randIndex]);
                this.usedCards.add(randIndex);
                done = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                ", usedCards=" + usedCards +
                '}';
    }
}
