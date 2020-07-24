package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Puzzle {
    int difficultyLevel;
    boolean physical;

    public Puzzle() {
        this.difficultyLevel = 0;
        this.physical = true;
    }
    public Puzzle(int difficultyLevel, boolean physical) {
        this.difficultyLevel = difficultyLevel;
        this.physical = physical;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public boolean isPhysical() {
        return physical;
    }

    public void setPhysical(boolean physical) {
        this.physical = physical;
    }
}
