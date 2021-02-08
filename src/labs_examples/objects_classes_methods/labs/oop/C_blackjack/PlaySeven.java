package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlaySeven {
    /*
    Notes 11-27-20
        ArrayList<SevenPlayer> doesn't work very well for rotating through players
        and <? extends SevenPlayer> doesn't work either
    Notes 12-3-20
        Need to figure out how to give joker-replaced card id 100 or whatever to indicate it has been replaced
        Need to figure out player rotation loop

     */
    static int gamesPlayed;

    public static void playSeven() {
        ArrayList<SevenComputerPlayer> gamePlayers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        /*System.out.println("Human player? (y for yes; n for no)");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Enter your player's name: ");
            String playerName = scanner.nextLine();
            SevenHumanPlayer player = new SevenHumanPlayer(playerName);
            gamePlayers.add(player);
        }*/

        System.out.println("Enter number of computer players: ");
        int x = scanner.nextInt();
        while (x > 0) {
            SevenComputerPlayer computer = new SevenComputerPlayer("Computer_" + x);
            gamePlayers.add(computer);
            x--;
        }
        Deck deck = new Deck();
        deck.dealSeven(gamePlayers);

        System.out.println("\n---------New-Game--------");

        //find 7 of Hearts
        int firstPlayerIndex = 0;
        for (SevenComputerPlayer sevenPlayer : gamePlayers) {
            for (ArrayList<Card> suit : sevenPlayer.hand.cards) {
                for (Card card : suit) {
                    if ((card.cardValue + card.suit).equalsIgnoreCase("7♥")) {
                        SevenGameBoard.hearts.add(card);
                        sevenPlayer.hand.cards.remove(card);
                        firstPlayerIndex = gamePlayers.indexOf(sevenPlayer);
                        break;
                    }
                }
            }
        }

        boolean gameOver = false;
        int i = 0;

        gamePlayers.get(0).hand.sortDescending();
        System.out.println(gamePlayers.get(0).hand.buildCards());
        int worstIdTest = gamePlayers.get(0).getWorstId();
        System.out.println(worstIdTest);
        for (ArrayList<Card> suit : gamePlayers.get(0).hand.cards) {
            for (Card card : suit) {
                if (card.id == worstIdTest) {
                    System.out.println(card);
                }
            }
        }



        while (!gameOver) {
            //if false, transfer worst card from previous player to current
            if (!GameLogic.play(gamePlayers.get(i))) {
                int prevPlayer = 0;
                if (i == 0) {
                    prevPlayer = gamePlayers.size() - 1;
                } else {
                    prevPlayer = i-1;
                }
                while (gamePlayers.get(prevPlayer).hand.cards.size() == 1) {
                    prevPlayer--;
                    if (prevPlayer == 0) {
                        prevPlayer = gamePlayers.size() - 1;
                    }
                }
                gamePlayers.get(i).hand.cards.add(gamePlayers.get(prevPlayer).hand.cards.get(gamePlayers.get(prevPlayer).getWorstId()));
                gamePlayers.get(prevPlayer).hand.cards.remove(gamePlayers.get(prevPlayer).getWorstId());
            }
            //print the gameboard


            for (SevenComputerPlayer sevenPlayer : gamePlayers) {
                if (sevenPlayer.hand.cards.size() == 0) {
                    gameOver = true;
                }
            }
        }

        Collections.sort(gamePlayers, (p1, p2) -> Integer.valueOf(p1.hand.cards.size()).compareTo(p2.hand.cards.size()));
        if (gamePlayers.get(0).hand.cards.size() != 0) {
            System.out.println("Something went wrong. Winning player does not have 0 cards.");
        } else {
            System.out.println(gamePlayers.get(0).name + " won!");
            for (int n = 1; i < gamePlayers.size(); n++) {
                System.out.println(gamePlayers.get(n).name + " placed in position " + i);
            }
        }
    }


}