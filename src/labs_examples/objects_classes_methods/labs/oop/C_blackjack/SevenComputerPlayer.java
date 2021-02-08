package labs_examples.objects_classes_methods.labs.oop.C_blackjack;


import java.util.ArrayList;
import java.util.List;

public class SevenComputerPlayer extends SevenPlayer {

    public boolean prioritizeHigh;

    public SevenComputerPlayer(String name) {
        super(name);
        this.prioritizeHigh = true;
    }


   public int getWorstId() {
        //returns id of worst card in this player's hand
        int id = 0;
        //int[] index_suit = new int[2];
        hand.sortDescending();

       for (ArrayList<Card> suit : hand.cards) {
           for (Card card : suit) {
               if (card.id == 100) {
                   //joker
                   return 100;
               }
           }
       }

       for (ArrayList<Card> suit : hand.cards) {
           for (Card card : suit) {
               //non-heart ace
               if (card.cardNumber == 1 && !card.suit.equalsIgnoreCase("♥")) {
                   return card.id;
               }
           }
       }

       for (ArrayList<Card> suit : hand.cards) {
           for (Card card : suit) {
               //ace
               if (card.cardNumber == 1) {
                   return card.id;
               }
           }
       }

       for (ArrayList<Card> suit : hand.cards) {
           for (Card card : suit) {
               //high card
               if (prioritizeHigh) {
                   return suit.get(0).id;
               }
           }
       }

       for (ArrayList<Card> suit : hand.cards) {
           for (Card card : suit) {
               if (!prioritizeHigh) {
                   if (suit.get(suit.size()-1).id == 0) {
                       id = suit.get(suit.size()-2).id;
                   } else {
                       id = suit.get(suit.size()-1).id;
                   }
                   return id;
               }
           }
       }

       return 69420;
    }
}
