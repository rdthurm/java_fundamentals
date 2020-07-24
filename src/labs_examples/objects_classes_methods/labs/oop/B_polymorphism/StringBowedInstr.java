package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class StringBowedInstr extends StringedInstr {
    String[] instrTypes;
    String instrName;

    public StringBowedInstr(int instrName) {
        super("catgut", 4, false);
        this.instrTypes = new String[]{"violin", "viola", "cello", "double bass"};
        this.instrName = instrTypes[instrName];
    }

    public StringBowedInstr(String stringType, int stringAmount, boolean tuned, int instrName) {
        super(stringType, stringAmount, tuned);
        this.instrTypes = new String[]{"violin", "viola", "cello", "double bass"};
        this.instrName = instrTypes[instrName];
    }

    public StringBowedInstr(String stringType, int stringAmount, boolean fretted, boolean tuned, int instrName) {
        super(stringType, stringAmount, fretted, tuned);
        this.instrTypes = new String[]{"violin", "viola", "cello", "double bass"};
        this.instrName = instrTypes[instrName];
    }

    @Override
    public void playChord(String chord) {
        System.out.println("Bow multiple strings to create a " + chord + " chord.");
    }

    public void applyResin(){
        System.out.println("Apply resin to bow.");
    }
    public void tuneWithEnsemble(){
        System.out.println("Tune with ensemble.");
    }

    @Override
    public String toString() {
        return "StringBowedInstr{" +
                "instrName='" + instrName + '\'' +
                ", stringType='" + stringType + '\'' +
                ", stringAmount=" + stringAmount +
                ", fretted=" + fretted +
                ", tuned=" + tuned +
                '}';
    }
}
