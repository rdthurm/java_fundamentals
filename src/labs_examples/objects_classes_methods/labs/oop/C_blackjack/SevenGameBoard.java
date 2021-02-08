package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class SevenGameBoard {
    public static boolean gameOver;
    public static ArrayList<Card> hearts = new ArrayList();
    public static ArrayList<Card> spades = new ArrayList();
    public static ArrayList<Card> diamonds = new ArrayList();
    public static ArrayList<Card> clubs = new ArrayList();
    public static ArrayList<ArrayList<Card>> board = new ArrayList();
    public static ArrayList<Card> openings = new ArrayList();
    //cardBank is used to populate openings -- It's not a combination of the played cards
    public static ArrayList<Card> cardBank = new ArrayList();
    public static int[] heartRange;

    /*public SevenGameBoard() {
        this.hearts = new ArrayList();
        this.spades = new ArrayList();
        this.diamonds = new ArrayList();
        this.clubs = new ArrayList();
        this.clubs = new ArrayList();
        this.openings = new ArrayList();
       // this.cardBank = new ArrayList();
        this.heartRange = new int[2];
        this.board = new ArrayList<>();
        board.add(hearts);
        board.add(clubs);
        board.add(diamonds);
        board.add(spades);
    }*/

    public static int[] getSuitRange(ArrayList<Card> suit) {
        //index 0 will be lowest number, index 1 will be highest
        //outputs [-1, 0] if empty
        int[] array = new int[2];

        if (suit.isEmpty()) {
            array[0] = -1;
            array[1] = 0;
        }

        if (suit.size() == 1) {
            array[0] = 7;
            array[1] = 7;
        }

        if (suit.get(0).cardNumber == 0) {
            array[0] = suit.get(1).cardNumber - 1;
        } else {
            array[0] = suit.get(0).cardNumber;
        }

        if (suit.get(suit.size() - 1).cardNumber == 0) {
            array[1] = suit.get(suit.size() - 2).cardNumber + 1;
        } else {
            array[1] = suit.get(suit.size() - 1).cardNumber;
        }
        return array;
    }

    public static boolean checkGameOver() {
        boolean thirteen = true;
        for (ArrayList<Card> suit : board) {
            if (suit.size() < 13) {
                thirteen = false;
            }
        }
        return thirteen;
    }

    public static void processOpeningsAndRange() {
        openings.clear();
        for (Card card : cardBank) {
            if (card.cardNumber == 0 && card.suit.equalsIgnoreCase("Joker")) {
                openings.add(card);
            }
        }

        if (hearts.isEmpty()) {
            for (Card card : cardBank) {
                if (card.cardNumber == 7 && card.suit.equalsIgnoreCase("♥")) {
                    openings.add(card);
                }
            }
        }
        if (hearts.size() == 1) {
            for (Card card : cardBank) {
                if ((card.cardNumber == 6 || card.cardNumber == 8) && card.suit.equalsIgnoreCase("♥")) {
                    openings.add(card);
                }
            }
        }
        if (hearts.get(0).cardNumber == 0) {
            for (Card card : cardBank) {
                if ((card.cardNumber == hearts.get(1).cardNumber - 2) && card.suit.equalsIgnoreCase("♥")) {
                    openings.add(card);
                }
            }
        } else {
            for (Card card : cardBank) {
                if (card.cardNumber == hearts.get(0).cardNumber - 1 && card.suit.equalsIgnoreCase("♥")) {
                    openings.add(card);
                }
            }
        }
        if (hearts.get(hearts.size()-1).cardNumber == 0) {
            for (Card card : cardBank) {
                if ((card.cardNumber == hearts.get(hearts.size()-2).cardNumber + 2) && card.suit.equalsIgnoreCase("♥")) {
                    openings.add(card);
                }
            }
        } else {
            for (Card card : cardBank) {
                if (card.cardNumber == hearts.get(hearts.size()-1).cardNumber + 1 && card.suit.equalsIgnoreCase("♥")) {
                    openings.add(card);
                }
            }
        }

        //---------------------------------------------------------------------


        if (clubs.isEmpty()) {
            for (Card card : cardBank) {
                if (card.cardNumber == 7 && card.suit.equalsIgnoreCase("♣")) {
                    openings.add(card);
                }
            }
        }
        if (clubs.size() == 1) {
            for (Card card : cardBank) {
                if ((card.cardNumber == 6 || card.cardNumber == 8) && card.suit.equalsIgnoreCase("♣")) {
                    openings.add(card);
                }
            }
        }
        if (clubs.get(0).cardNumber == 0) {
            for (Card card : cardBank) {
                if ((card.cardNumber == clubs.get(1).cardNumber - 2) && card.suit.equalsIgnoreCase("♣")) {
                    openings.add(card);
                }
            }
        } else {
            for (Card card : cardBank) {
                if (card.cardNumber == clubs.get(0).cardNumber - 1 && card.suit.equalsIgnoreCase("♣")) {
                    openings.add(card);
                }
            }
        }
        if (clubs.get(clubs.size()-1).cardNumber == 0) {
            for (Card card : cardBank) {
                if ((card.cardNumber == clubs.get(clubs.size()-2).cardNumber + 2) && card.suit.equalsIgnoreCase("♣")) {
                    openings.add(card);
                }
            }
        } else {
            for (Card card : cardBank) {
                if (card.cardNumber == clubs.get(clubs.size()-1).cardNumber + 1 && card.suit.equalsIgnoreCase("♣")) {
                    openings.add(card);
                }
            }
        }

//---------------------------------------------------------------------

        if (diamonds.isEmpty()) {
            for (Card card : cardBank) {
                if (card.cardNumber == 7 && card.suit.equalsIgnoreCase("♦")) {
                    openings.add(card);
                }
            }
        }
        if (diamonds.size() == 1) {
            for (Card card : cardBank) {
                if ((card.cardNumber == 6 || card.cardNumber == 8) && card.suit.equalsIgnoreCase("♦")) {
                    openings.add(card);
                }
            }
        }
        if (diamonds.get(0).cardNumber == 0) {
            for (Card card : cardBank) {
                if ((card.cardNumber == diamonds.get(1).cardNumber - 2) && card.suit.equalsIgnoreCase("♦")) {
                    openings.add(card);
                }
            }
        } else {
            for (Card card : cardBank) {
                if (card.cardNumber == diamonds.get(0).cardNumber - 1 && card.suit.equalsIgnoreCase("♦")) {
                    openings.add(card);
                }
            }
        }
        if (diamonds.get(diamonds.size()-1).cardNumber == 0) {
            for (Card card : cardBank) {
                if ((card.cardNumber == diamonds.get(diamonds.size()-2).cardNumber + 2) && card.suit.equalsIgnoreCase("♦")) {
                    openings.add(card);
                }
            }
        } else {
            for (Card card : cardBank) {
                if (card.cardNumber == diamonds.get(diamonds.size()-1).cardNumber + 1 && card.suit.equalsIgnoreCase("♦")) {
                    openings.add(card);
                }
            }
        }

        //---------------------------------------------------------------------

        if (spades.isEmpty()) {
            for (Card card : cardBank) {
                if (card.cardNumber == 7 && card.suit.equalsIgnoreCase("♠")) {
                    openings.add(card);
                }
            }
        }
        if (spades.size() == 1) {
            for (Card card : cardBank) {
                if ((card.cardNumber == 6 || card.cardNumber == 8) && card.suit.equalsIgnoreCase("♠")) {
                    openings.add(card);
                }
            }
        }
        if (spades.get(0).cardNumber == 0) {
            for (Card card : cardBank) {
                if ((card.cardNumber == spades.get(1).cardNumber - 2) && card.suit.equalsIgnoreCase("♠")) {
                    openings.add(card);
                }
            }
        } else {
            for (Card card : cardBank) {
                if (card.cardNumber == spades.get(0).cardNumber - 1 && card.suit.equalsIgnoreCase("♠")) {
                    openings.add(card);
                }
            }
        }
        if (spades.get(spades.size()-1).cardNumber == 0) {
            for (Card card : cardBank) {
                if ((card.cardNumber == spades.get(spades.size()-2).cardNumber + 2) && card.suit.equalsIgnoreCase("♠")) {
                    openings.add(card);
                }
            }
        } else {
            for (Card card : cardBank) {
                if (card.cardNumber == spades.get(spades.size()-1).cardNumber + 1 && card.suit.equalsIgnoreCase("♠")) {
                    openings.add(card);
                }
            }
        }
        //---------------------------------------------------
        //delete ones out of hearts range
        for (Card card : openings) {
            if (card.cardNumber < hearts.get(0).cardNumber - 1 && ! card.suit.equalsIgnoreCase("♥")) {
                openings.remove(card);
            } else if (card.cardNumber > hearts.get(hearts.size()-1).cardNumber + 1 && ! card.suit.equalsIgnoreCase("♥")) {
                openings.remove(card);
            } else {
                continue;
            }
        }


    }



    @Override
    public String toString() {
        return "SevenGameBoard{" +
                "hearts=" + hearts +
                ", spades=" + spades +
                ", diamonds=" + diamonds +
                ", clubs=" + clubs +
                '}';
    }
}
