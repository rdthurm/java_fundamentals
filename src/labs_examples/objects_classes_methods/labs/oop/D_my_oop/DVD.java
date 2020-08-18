package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class DVD extends Item {
    private String rating;
    private int runtime;

    public DVD(int rentalPeriod, String title, String rating, int runtime) {
        super(rentalPeriod, title);
        this.rating = rating;
        this.runtime = runtime;
    }
}
