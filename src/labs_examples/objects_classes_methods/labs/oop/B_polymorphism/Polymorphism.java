package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class Polymorphism {
    public static void main(String[] args) {

        StringBowedInstr violin = new StringBowedInstr(0);
        System.out.println(violin.toString());
        StringBowedInstr viola = new StringBowedInstr(1);
        System.out.println(viola.toString());
        StringBowedInstr cello = new StringBowedInstr("aluminum", 4, false, false, 2);
        System.out.println(cello);
        StringBowedInstr doublebass = new StringBowedInstr("catgut", 4, false, 3);
        System.out.println(doublebass.toString());

        StringedPluckedInstr acoustic = new StringedPluckedInstr();
        System.out.println(acoustic);
        StringedPluckedInstr jazzbass = new StringedPluckedInstr("plastic", 4, false, 0, true);
        System.out.println(jazzbass);
        acoustic.playChord("G7");
        jazzbass.playNote("F");
        viola.playNote("C");
        violin.playChord("Ab");

        Instrument piano = new Instrument();
        Car newcar = new Car(24, false, piano);
        newcar.carMaintain.polish();
    }
}
