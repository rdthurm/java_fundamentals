package labs_examples.objects_classes_methods.labs.oop.C_blackjack;



public class Card {
    boolean jokerReplaced;
    String cardValue;
    int cardNumber;
    String suit;
    int id;
    int sevenScore;


    public Card(String cardValue, String suit, int id) {
        this.cardValue = cardValue;
        switch (this.cardValue) {
            case "Joker":
                this.sevenScore = 50;
                break;
            case "A":
                this.cardNumber = 1;
                this.sevenScore = 15;
                break;
            case "J":
                this.cardNumber = 11;
                this.sevenScore = 10;
                break;
            case "Q":
                this.cardNumber = 12;
                this.sevenScore = 10;
                break;
            case "K":
                this.cardNumber = 13;
                this.sevenScore = 10;
                break;
            default:
                this.cardNumber = Integer.parseInt(this.cardValue);
                this.sevenScore = 5;
        }
        this.suit = suit;
        this.jokerReplaced = false;
        this.id = id;
    }

    public Card(String cardValue) {
        this.cardValue = "Joker";
        this.cardNumber = 0;
        this.sevenScore = 50;
        this.id = 200;
        this.suit = "Joker";
    }

    public void gotJokered() {
        //sets ID to 100, which will mean it's the card that got jokered
        this.id = 100;
    }

    @Override
    public String toString() {
        return "Card{" + cardValue + suit +
                '}';
    }

}
