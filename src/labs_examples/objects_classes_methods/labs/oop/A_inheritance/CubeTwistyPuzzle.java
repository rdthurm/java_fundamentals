package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

import java.util.Arrays;

public class CubeTwistyPuzzle extends TwistyPuzzle {
    int[] dimensions;
    String colorScheme;

    public CubeTwistyPuzzle() {
        super();
        super.difficultyLevel = 3;
        this.dimensions = new int[]{3, 3, 3};
        this.colorScheme = "standard";
    }
    public CubeTwistyPuzzle(int...dimensions) {
        super();
        this.dimensions = dimensions;
        this.colorScheme = "standard";
    }
    public CubeTwistyPuzzle(int difficultyLevel, boolean physical, String color, String brand, boolean springCore, boolean solved,
                            String colorScheme, int...dimensions) {
        super(difficultyLevel, physical, color, brand, springCore, solved);
        this.dimensions = dimensions;
        this.colorScheme = colorScheme;
    }

    @Override
    public void reSticker(){
        System.out.println("Add new stickers to cube puzzle.");
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }

    public String getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(String colorScheme) {
        this.colorScheme = colorScheme;
    }

    @Override
    public String toString() {
        return "CubeTwistyPuzzle{" +
                "dimensions=" + Arrays.toString(dimensions) +
                ", colorScheme='" + colorScheme + '\'' +
                ", plasticColor='" + plasticColor + '\'' +
                ", brand='" + brand + '\'' +
                ", springCore=" + springCore +
                ", solved=" + solved +
                ", difficultyLevel=" + difficultyLevel +
                ", physical=" + physical +
                '}';
    }
}
