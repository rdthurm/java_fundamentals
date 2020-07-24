package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class TwistyPuzzle extends Puzzle {
    String plasticColor;
    String brand;
    boolean springCore;
    boolean solved;
    public TwistyPuzzle() {
        super();
        this.plasticColor = "black";
        this.brand = "Rubiks";
        this.springCore = false;
        this.solved = true;
    }
    public TwistyPuzzle(int difficultyLevel, boolean physical, String color, String brand, boolean springCore, boolean solved) {
        super(difficultyLevel, physical);
        this.plasticColor = color;
        this.brand = brand;
        this.springCore = springCore;
        this.solved = solved;
    }
    public void rotate(){
        System.out.println("Rotate 90 degrees.");
    }

    public void scramble(){
        solved = false;
    }

    public void reSticker(){
        System.out.println("Add new stickers.");
    }
}
