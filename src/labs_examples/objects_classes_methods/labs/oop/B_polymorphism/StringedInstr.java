package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public abstract class StringedInstr extends Instrument implements InstrumentInterface {
    String stringType;
    int stringAmount;
    boolean fretted;

    public StringedInstr(String stringType, int stringAmount, boolean fretted) {
        super();
        this.stringType = stringType;
        this.stringAmount = stringAmount;
        this.fretted = fretted;
    }

    public StringedInstr(String stringType, int stringAmount, boolean fretted, boolean tuned) {
        super.tuned = tuned;
        this.stringType = stringType;
        this.stringAmount = stringAmount;
        this.fretted = fretted;
    }


    @Override
    public void playNote(String note) {
        System.out.println("Play a " + note + " note on a lower string for a darker timbre," +
                " and play on a higher string for a brighter timbre.");
    }

    @Override
    public String toString() {
        return "StringedInstr{" +
                "stringType='" + stringType + '\'' +
                ", stringAmount=" + stringAmount +
                ", fretted=" + fretted +
                ", tuned=" + tuned +
                '}';
    }
}
