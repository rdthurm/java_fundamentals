package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    String name;
    Hand hand;
    int chips;

    public Player(String name, int chips) {
        this.hand = new Hand();
        this.name = name;
        this.chips = chips;
    }

    public boolean computerAI(){
        if (this.hand.handScore() <= 16){
            return true;
        } else {
            return false;
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
