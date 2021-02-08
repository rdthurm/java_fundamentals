package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class GameLogic {

    public static boolean play(SevenComputerPlayer player) {
        //return true if play is made, else return false and main method will call getWorst() on previous player and
        //give that card to current player
        System.out.println("--------------------------\n" + player.name + "'s turn");

        //compare number of >7 to <7 cards in hand. Prioritize high or low based on that
        //getWorst() function
        //      joker replace 1st
        //      Ace of not heart, ace of heart
        //          If prioritize high:
        //              King not heart, king, Queen not heart, queen...
        //          If prioritize low:
        //              2 not heart, 2 heart, 3 not heart, 3 heart...
        //make hold list (don't play until it's the only option):
        //      7s that don't need to be played yet
        //      Hearts that don't need to be played yet
        //normal play logic:
        //      check heart range
        //      check other ranges
        //      if prioritize high, play highest card you can - most pop suit first - hearts last
        //      if prioritize low, play highest low card (6 and under) you can - most pop suit first - hearts last
        //      if no other option, play 7 of your most pop suit
        //      if no 7, play joker in the high or low slow of your most pop suit depending on priority
        //      if no joker, ask for card from previous opponent


        player.prioritizeHigh = player.hand.setHighLowPriority();
        //popSuits ranks the index most to least populated non-heart suit in player.hand.cards
        //skips 0 since hearts are index 0

        ArrayList<Integer> popSuits = new ArrayList();
        //clubs = index 1, diamonds = index 2, spades = index 3 (hearts = index 0)
        popSuits.add(1);
        popSuits.add(2);
        popSuits.add(3);
        for (int i = 0; i < 2; i++) {
            if (player.hand.cards.get(popSuits.get(i+1)).size() > player.hand.cards.get(popSuits.get(i)).size()) {
                Collections.swap(popSuits, i+1, i);
            }
        }

        SevenGameBoard.processOpeningsAndRange();

        boolean playMade = false;

        if (player.prioritizeHigh) {
            player.hand.sortDescending();
            while (! playMade) {
                for (int j = 0; j < 52; j++) {
                    for (int i = 0; i < 3; i++) {
                        if (SevenGameBoard.openings.contains(player.hand.cards.get(popSuits.get(i)).get(j))) {
                            SevenGameBoard.board.get(popSuits.get(i)).add(player.hand.cards.get(popSuits.get(i)).get(j));
                            player.hand.cards.get(popSuits.get(i)).remove(j);
                           /* switch (popSuits.get(i)) {
                                case 1:
                                    SevenGameBoard.clubs.add(player.hand.cards.get(1).get(j));
                                    player.hand.cards.get(1).remove(j);
                                    break;
                                case 2:
                                    SevenGameBoard.diamonds.add(player.hand.cards.get(2).get(j));
                                    player.hand.cards.get(2).remove(j);
                                    break;
                                case 3:
                                    SevenGameBoard.spades.add(player.hand.cards.get(3).get(j));
                                    player.hand.cards.get(3).remove(j);
                                    break;
                            }*/
                            System.out.println(player.name + " played the " + player.hand.cards.get(popSuits.get(i)).get(j).cardValue + player.hand.cards.get(popSuits.get(i)).get(j).suit);
                            playMade = true;
                        }
                    }
                }
                //now play highest heart
                for (int i = 0; i < 13; i++) {
                    if (SevenGameBoard.openings.contains(player.hand.cards.get(0).get(i))) {
                        SevenGameBoard.hearts.add(player.hand.cards.get(0).get(i));
                        player.hand.cards.get(0).remove(i);
                        System.out.println(player.name + " played the " + player.hand.cards.get(0).get(i).cardValue + player.hand.cards.get(0).get(i).suit);
                        playMade = true;
                    }
                }
                //check hand for joker and play
                for (ArrayList<Card> suit : player.hand.cards) {
                    for (Card card : suit) {
                        if (card.cardNumber == 0) {
                            //play joker in high opening of mostpopsuit and remove what it replaced from openings, change card it replaced to id 100
                            SevenGameBoard.board.get(popSuits.get(0)).add(card);
                            player.hand.cards.remove(card);
                            if (SevenGameBoard.board.get(0).size() == 1) {
                                System.out.println(player.name + " played the Joker, which replaces the 7♥");
                            }
                            else {
                                for (Card openCard : SevenGameBoard.openings) {
                                    if (openCard.id == SevenGameBoard.board.get(popSuits.get(0)).get(SevenGameBoard.board.get(popSuits.get(0)).size()-2).id) {
                                        SevenGameBoard.openings.remove(openCard);
                                        System.out.println(player.name + " played the Joker, which replaces the " + openCard.suit + openCard.cardValue);
                                    }
                                }
                            }
                            playMade = true;
                        }
                    }
                }
            }
        } else {
            player.hand.sortAscending();

            while (! playMade) {
                for (int j = 0; j < 52; j++) {
                    for (int i = 0; i < 3; i++) {
                        if (SevenGameBoard.openings.contains(player.hand.cards.get(popSuits.get(i)).get(j))) {
                            SevenGameBoard.board.get(popSuits.get(i)).add(0, player.hand.cards.get(popSuits.get(i)).get(j));
                            player.hand.cards.get(popSuits.get(i)).remove(j);
                            System.out.println(player.name + " played the " + player.hand.cards.get(popSuits.get(i)).get(j).cardValue + player.hand.cards.get(popSuits.get(i)).get(j).suit);
                            playMade = true;
                        }
                    }
                }
                //now play highest heart
                for (int i = 0; i < 13; i++) {
                    if (SevenGameBoard.openings.contains(player.hand.cards.get(0).get(i))) {
                        SevenGameBoard.hearts.add(0, player.hand.cards.get(0).get(i));
                        player.hand.cards.get(0).remove(i);
                        System.out.println(player.name + " played the " + player.hand.cards.get(0).get(i).cardValue + player.hand.cards.get(0).get(i).suit);
                        playMade = true;
                    }
                }
                //check hand for joker and play
                for (ArrayList<Card> suit : player.hand.cards) {
                    for (Card card : suit) {
                        if (card.cardNumber == 0) {
                            //play joker in high opening of mostpopsuit and remove what it replaced from openings
                            SevenGameBoard.board.get(popSuits.get(0)).add(0, card);
                            player.hand.cards.remove(card);
                            if (SevenGameBoard.board.get(popSuits.get(0)).size() == 1) {
                                System.out.println(player.name + " played the Joker, which replaces the 7♥");
                            }
                            else {
                                for (Card openCard : SevenGameBoard.openings) {
                                    if (openCard.id == SevenGameBoard.board.get(popSuits.get(0)).get(SevenGameBoard.board.get(popSuits.get(0)).size()-2).id) {
                                        SevenGameBoard.openings.remove(openCard);
                                        System.out.println(player.name + " played the Joker, which replaces the " + openCard.suit + openCard.cardValue);
                                    }
                                }
                            }
                            playMade = true;
                        }
                    }
                }
                if (!playMade) break;
            }
        }

        return playMade;
    }





}
