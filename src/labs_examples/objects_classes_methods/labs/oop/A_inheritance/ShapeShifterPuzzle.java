package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class ShapeShifterPuzzle extends TwistyPuzzle {
    String solvedShape;

    public ShapeShifterPuzzle(String solvedShape) {
        super();
        this.solvedShape = solvedShape;
    }

    public ShapeShifterPuzzle(int difficultyLevel, boolean physical, String color, String brand, boolean springCore,
                              boolean solved, String solvedShape) {
        super(difficultyLevel, physical, color, brand, springCore, solved);
        this.solvedShape = solvedShape;
    }

    public String getSolvedShape() {
        return solvedShape;
    }

    public void setSolvedShape(String solvedShape) {
        this.solvedShape = solvedShape;
    }

    @Override
    public void reSticker(){
        System.out.println("Add new stickers to shape-shifting puzzle.");
    }

    @Override
    public void rotate() {
        System.out.println("Rotate 180 degrees.");
    }

    @Override
    public String toString() {
        return "ShapeShifterPuzzle{" +
                "solvedShape='" + solvedShape + '\'' +
                ", plasticColor='" + plasticColor + '\'' +
                ", brand='" + brand + '\'' +
                ", springCore=" + springCore +
                ", solved=" + solved +
                ", difficultyLevel=" + difficultyLevel +
                ", physical=" + physical +
                '}';
    }
}
