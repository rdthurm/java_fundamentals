package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class SevenPlayer {
    String name;
    Hand hand;

    public SevenPlayer(String name) {
        this.hand = new Hand();
        this.name = name;
    }

}
