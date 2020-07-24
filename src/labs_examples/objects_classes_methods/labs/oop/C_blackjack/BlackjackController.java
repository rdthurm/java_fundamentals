package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Scanner;

public class BlackjackController {
    public static void main(String[] args) {
        playBlackjack();
    }

    public static void playBlackjack(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your player's name: ");
        String playerName = scanner.nextLine();
        System.out.println("Enter chips that both players will begin with: ");
        int stakes = scanner.nextInt();
        Player player = new Player(playerName, stakes);
        Player computer = new Player("Computer", stakes);

        while (player.chips > 0 && computer.chips > 0) {
            player.hand.cards.clear();
            computer.hand.cards.clear();
            System.out.println("\n---------New-Hand--------");
            System.out.println("Enter bet: ");
            int bet = scanner.nextInt();
            while (bet > player.chips) {
                System.out.println("You only have " + player.chips + " chips left!");
                System.out.println("Try again: ");
                bet = scanner.nextInt();
            }
            while (bet > computer.chips) {
                System.out.println("Computer only has " + computer.chips + " chips left!");
                System.out.println("That's the max you can bet. Try again: ");
                bet = scanner.nextInt();
            }
            int won = 0;
            Deck deck = new Deck();
            deck.deal(player);
            deck.deal(player);
            deck.deal(computer);
            deck.deal(computer);
            System.out.println("Your cards: " + player.hand.buildCards());
            System.out.println("Your total: " + player.hand.handScore());
            System.out.println("Dealer upcard: " + computer.hand.cards.get(0).cardValue);
            System.out.println("Do you want another card?");
            while (player.hand.handScore() <= 21) {
                String move = scanner.next();
                if (move.equals("y")) {
                    deck.deal(player);
                    System.out.println("Your cards are: " + player.hand.buildCards());
                    System.out.println("And your total is: " + player.hand.handScore());
                    System.out.println("Do you want another card?");
                } else if (move.equals("n")) {
                    break;
                }
            }
            while (computer.computerAI()) {
                deck.deal(computer);
            }
            int yourTotal = player.hand.handScore();
            int computerTotal = computer.hand.handScore();
            System.out.println("Your FINAL cards: " + player.hand.buildCards());
            System.out.println("Dealer's FINAL cards: " + computer.hand.buildCards());
            System.out.println("Your FINAL total: " + yourTotal);
            System.out.println("Dealer's FINAL total: " + computerTotal);
            System.out.println("------------------------");
            if (yourTotal > 21) {
                System.out.println("YOU LOSE");
                won = 1;
            } else if (yourTotal < computerTotal && computerTotal <= 21) {
                System.out.println("YOU LOSE");
                won = 1;
            } else if (yourTotal == computerTotal) {
                System.out.println("PUSH");
            } else {
                System.out.println("YOU WIN");
                won = 2;
            }
            System.out.println("------------------------");
            if (won == 2) {
                player.chips += bet;
                computer.chips -= bet;
            } else if (won == 1) {
                computer.chips += bet;
                player.chips -= bet;
            }
            System.out.println("You have " + player.chips + " chips left.");
            System.out.println("The computer has " + computer.chips + " chips left.");
        }

        System.out.println("------------------------");
        if (player.chips <= 0){
            System.out.println("You are out of chips.\nGAME OVER - YOU LOSE");
        } else if (computer.chips <= 0){
            System.out.println("The computer is out of chips.\nGAME OVER - YOU WIN");
        }
    }
}
