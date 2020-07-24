package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class HierarchyController {
    public static void main(String[] args) {
        Puzzle sudoku = new Puzzle(3, false);

        CubeTwistyPuzzle rubiksCube = new CubeTwistyPuzzle();
        System.out.println(rubiksCube);
        CubeTwistyPuzzle fiveByFive = new CubeTwistyPuzzle(5,5,5);
        System.out.println(fiveByFive);
        CubeTwistyPuzzle fourXFour = new CubeTwistyPuzzle(6, true, "black", "Cube4U",
                true, true, "asian", 4,4,4);
        System.out.println(fourXFour.toString());

        DodecPuzzle megaminx = new DodecPuzzle();
        DodecPuzzle gigaminx = new DodecPuzzle(5);
        DodecPuzzle gigaminx2 = new DodecPuzzle(10, true, "black", "Mefferts", true, false, 5);
        System.out.println(gigaminx.toString());
        System.out.println(gigaminx2.toString());
        fourXFour.rotate();
        megaminx.rotate();
        megaminx.scramble();
        System.out.println(megaminx.solved);

        ShapeShifterPuzzle squareOne = new ShapeShifterPuzzle(7, true, "black",
                "off-brand", true, false, "square");
        System.out.println(squareOne.toString());
        squareOne.rotate();

        squareOne.reSticker();
        fourXFour.reSticker();
        megaminx.reSticker();

    }
}
