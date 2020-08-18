package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class CD extends Item {
    private int numOfDiscs;
    private int runtime;

    public CD(int rentalPeriod, String title, int numOfDiscs, int runtime) {
        super(rentalPeriod, title);
        this.numOfDiscs = numOfDiscs;
        this.runtime = runtime;
    }
}
