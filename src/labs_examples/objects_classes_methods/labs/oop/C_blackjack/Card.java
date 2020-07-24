package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Card {
    String cardValue;
    String suit;


    public Card(String cardValue, String suit) {
        this.cardValue = cardValue;
        this.suit = suit;

    }

    @Override
    public String toString() {
        return "Card{" +
                "cardValue='" + cardValue + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}
