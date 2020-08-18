package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.ArrayList;

public class Item {
    protected String title;
    protected String sortTitle;
    protected int stock;
    protected int rentalPeriod;
    protected ArrayList<Renter> pastRenters;

    public Item(int rentalPeriod, String title) {
        this.title = title;
        if (title.substring(0, 3).equals("The")){
            this.sortTitle = title.substring(4) + ", The";
        } else {
            this.sortTitle = title;
        }
        this.rentalPeriod = rentalPeriod;
    }

    public void acquire(int num){
        this.stock += num;
    }

    public void logRenter(Renter renter) {
        this.pastRenters.add(renter);
    }

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }


    public int getStock() {
        return stock;
    }

    public void addToStock(int num) {
        this.stock += num;
    }

    public void decStock() {
        this.stock -= 1;
    }
}
