package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.ArrayList;

public class Renter {
    private int customerID;
    private int feesOwed;
    public ArrayList<Item> holds;
    public ArrayList<Item> currentlyRenting;
    public ArrayList<Item> rentHistory;

    public Renter(int customerID) {
        this.customerID = customerID;
        this.holds = new ArrayList<Item>();
        this.currentlyRenting = new ArrayList<Item>();
        this.rentHistory = new ArrayList<Item>();

    }

    public void checkout(Item item){
        if (item.getStock() > 0) {
            currentlyRenting.add(item);
            if (holds.contains(item)){
                holds.remove(item);
            }
            item.decStock();
            System.out.println(item.title + " checked out by customer " + customerID);
        } else {
            System.out.println(item.title + " is out of stock");
        }
    }

    public void hold(Item item){
        if (item.getStock() == 0) {
            holds.add(item);
            System.out.println(item.title + " placed on hold by customer " + customerID);
        } else {
            System.out.println(item.title + " is in stock - no need to hold");
        }
    }

    public void checkin(Item item){
        if (currentlyRenting.contains(item)) {
            currentlyRenting.remove(item);
            rentHistory.add(item);
            item.stock++;
            System.out.println(item.title + " checked in by customer " + customerID);
        } else {
            System.out.println(item.title + " not checked out by customer " + customerID);
        }
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getFeesOwed() {
        return feesOwed;
    }

    public void setFeesOwed(int feesOwed) {
        this.feesOwed = feesOwed;
    }


}
