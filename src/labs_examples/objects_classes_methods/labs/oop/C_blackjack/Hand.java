package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;
    int handValue;

    public Hand() {
        this.cards = new ArrayList<>();
        this.handValue = 0;
    }

    public int handScore(){
        this.handValue = 0;
        for (Card card : cards) {
            String x = card.cardValue;
            if (x.equals("A")) {
                handValue++;
            } else if (x.equals("K") || x.equals("Q") || x.equals("J") || x.equals("10")) {
                handValue += 10;
            } else {
                handValue += Integer.parseInt(x);
            }
        }
        return handValue;
    }


    public ArrayList<String> buildCards(){
        ArrayList<String> builtCards = new ArrayList<>();
        for (Card card : this.cards){
            builtCards.add(card.cardValue + card.suit);
        }
        return builtCards;
    }


    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                ", handValue=" + handValue +
                '}';
    }
}
