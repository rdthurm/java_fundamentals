package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class DodecPuzzle extends TwistyPuzzle {
    int rowLength;

    public DodecPuzzle() {
        super();
        this.rowLength = 3;
    }

    public DodecPuzzle(int rowLength) {
        super();
        this.rowLength = rowLength;
    }

    public DodecPuzzle(int difficultyLevel, boolean physical, String color, String brand, boolean springCore,
                       boolean solved, int rowLength) {
        super(difficultyLevel, physical, color, brand, springCore, solved);
        this.rowLength = rowLength;
    }

    @Override
    public void reSticker(){
        System.out.println("Add new stickers to 12-sided puzzle.");
    }

    @Override
    public void rotate() {
        System.out.println("Rotate 30 degrees.");
    }

    @Override
    public String toString() {
        return "DodecPuzzle{" +
                "rowLength=" + rowLength +
                ", plasticColor='" + plasticColor + '\'' +
                ", brand='" + brand + '\'' +
                ", springCore=" + springCore +
                ", solved=" + solved +
                ", difficultyLevel=" + difficultyLevel +
                ", physical=" + physical +
                '}';
    }
}
