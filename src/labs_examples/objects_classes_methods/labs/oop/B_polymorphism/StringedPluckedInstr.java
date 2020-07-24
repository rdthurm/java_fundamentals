package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

import java.util.Arrays;

public class StringedPluckedInstr extends StringedInstr {
    String[] pluckOptions;
    String pluckMethod;
    boolean electric;

    public StringedPluckedInstr(){
        super("nickel", 6, true, true);
        this.pluckOptions = new String[]{"fingers", "single pick", "finger picks"};
        this.pluckMethod = pluckOptions[1];
        this.electric = false;
    }

    public StringedPluckedInstr(String stringType, int stringAmount, boolean fretted, int pluckMethod, boolean electric) {
        super(stringType, stringAmount, fretted);
        this.pluckOptions = new String[]{"fingers", "single pick", "finger picks"};
        this.pluckMethod = pluckOptions[pluckMethod];
        this.electric = electric;
    }

    @Override
    public void playChord(String chord) {
        System.out.println("Strum " + chord + " chord.");
    }

    @Override
    public String toString() {
        return "StringedPluckedInstr{" +
                "pluckMethod='" + pluckMethod + '\'' +
                ", electric=" + electric +
                ", stringType='" + stringType + '\'' +
                ", stringAmount=" + stringAmount +
                ", fretted=" + fretted +
                ", tuned=" + tuned +
                '}';
    }
}
