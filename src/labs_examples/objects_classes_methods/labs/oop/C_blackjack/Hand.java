package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    //"♠", "♦", "♥", "♣"

    ArrayList<Card> hearts;
    ArrayList<Card> clubs;
    ArrayList<Card> diamonds;
    ArrayList<Card> spades;
    ArrayList<Card> dealtCards;
    //hearts - 0, clubs - 1, diamonds - 2 spades - 3
    ArrayList<ArrayList<Card>> cards;
    int handValue;
    int lows = 0;
    int highs = 0;

    public Hand() {
        this.dealtCards = new ArrayList<>();
        this.hearts = new ArrayList<>();
        this.clubs = new ArrayList<>();
        this.diamonds = new ArrayList<>();
        this.spades = new ArrayList<>();
        this.cards = new ArrayList<>();
        cards.add(hearts);
        cards.add(clubs);
        cards.add(diamonds);
        cards.add(spades);
        this.handValue = 0;
        this.lows = 0;
        this.highs = 0;
    }

    public int handScore() {
        this.handValue = 0;
        for (ArrayList<Card> suit : cards) {
            for (Card card : suit) {
                String x = card.cardValue;
                if (x.equals("A")) {
                    handValue++;
                } else if (x.equals("K") || x.equals("Q") || x.equals("J") || x.equals("10")) {
                    handValue += 10;
                } else {
                    handValue += Integer.parseInt(x);
                }
            }
        }
        return handValue;
    }


    public ArrayList<String> buildCards() {
        ArrayList<String> builtCards = new ArrayList<>();
        for (ArrayList<Card> suit : cards) {
            for (Card card : suit) {
                builtCards.add(card.cardValue + card.suit);
            }
        }
        return builtCards;
    }

    public void splitBySuits() {
        for (Card card : dealtCards) {
            if (hearts.contains(card) ||
                    clubs.contains(card) ||
                    diamonds.contains(card) ||
                    spades.contains(card)) {
                continue;
            } else if (card.suit.equalsIgnoreCase("♥")) {
                hearts.add(card);
            } else if (card.suit.equalsIgnoreCase("♣")) {
                clubs.add(card);
            } else if (card.suit.equalsIgnoreCase("♦")) {
                diamonds.add(card);
            } else if (card.suit.equalsIgnoreCase("♠")) {
                spades.add(card);
            }
        }
    }

    public boolean setHighLowPriority() {
        for (ArrayList<Card> suit : cards) {
            for (Card card : suit) {
                if (card.cardNumber == 7 || card.cardNumber == 14) {
                    continue;
                } else if (card.cardNumber < 7) lows++;
                else if (card.cardNumber > 7) highs++;
            }
        }
        if (highs >= lows) {
            return true;
        } else return false;
    }

    public void sortAscending() {
        Collections.sort(hearts, (p1, p2) -> Integer.valueOf(p1.cardNumber).compareTo(p2.cardNumber));
        Collections.sort(clubs, (p1, p2) -> Integer.valueOf(p1.cardNumber).compareTo(p2.cardNumber));
        Collections.sort(diamonds, (p1, p2) -> Integer.valueOf(p1.cardNumber).compareTo(p2.cardNumber));
        Collections.sort(spades, (p1, p2) -> Integer.valueOf(p1.cardNumber).compareTo(p2.cardNumber));
    }

    public void sortDescending() {
        Collections.sort(hearts, (p1, p2) -> Integer.valueOf(p2.cardNumber).compareTo(p1.cardNumber));
        Collections.sort(clubs, (p1, p2) -> Integer.valueOf(p2.cardNumber).compareTo(p1.cardNumber));
        Collections.sort(diamonds, (p1, p2) -> Integer.valueOf(p2.cardNumber).compareTo(p1.cardNumber));
        Collections.sort(spades, (p1, p2) -> Integer.valueOf(p2.cardNumber).compareTo(p1.cardNumber));
    }

}

