package labs_examples.packages.labs;

import java.util.ArrayList;
import java.util.Collections;

/*
ideas:
names - Even
        Evenout
        MakeCents
        Dollaback
        Friendspend

App would work like this:
    1) You start a "trip" and send links for people to join.
    2) Each person logs what they payed for, and everyone else votes to confirm it
     and whether or not they will pay a portion of that or not.
    3) At the end of the trip, the app shows a breakdown of each item and who was involved,
     everyone must confirm, then it runs the balance() thing and automatically executes
     the transactions.
    4) There is an in-app game that people can play throughout the trip, and whoever
    gets the highest score during the trip gets the rounded cents.



 */
public class payBalancer {
    public static void main(String[] args) {

        Wallet Luke = new Wallet("Luke");
        Wallet Dillon = new Wallet("Dillon");
        Wallet Riley = new Wallet("Riley");
        Wallet Hank = new Wallet("Hank");

        Riley.buy(22.56);
        Luke.buy(3.67);
        Dillon.buy(25.43);
        Hank.buy(31.21);

        balance();

    }

    static double round(double num){
        return Math.round(num * 100.0) / 100.0;
    }

    private static void balance() {

        double average = round(Wallet.pot / Wallet.numOfWallets);
        System.out.println("Pot: " + Wallet.pot + "\nAverage: " + average);
        int i = Wallet.arrayList.size() - 1;
        int j = 0;
        double top;
        double bottom;
        boolean go = true;
        int counter = Wallet.numOfWallets;
        double pay;
        //sorts lowest to highest:
        Collections.sort(Wallet.arrayList, (p1, p2) -> Double.valueOf(p1.amountSpent).compareTo(p2.amountSpent));
        while (counter > 0) {
            top = Wallet.arrayList.get(i).amountSpent;
            bottom = Wallet.arrayList.get(j).amountSpent;
            if (top == bottom) {
                System.out.println("Top and bottom are the same person.");
                break;
            }
            if (top - (average - bottom) >= average){
                pay = round(average - bottom);
                System.out.println(Wallet.arrayList.get(j).name + " pays " +
                        Wallet.arrayList.get(i).name + " " + (pay));
                Wallet.arrayList.get(i).amountSpent -= (pay);
                Wallet.arrayList.get(j).amountSpent += (pay);
                round(Wallet.arrayList.get(i).amountSpent);
                round(Wallet.arrayList.get(j).amountSpent);
            } else if (top - (average - bottom) < average){
                pay = round(top - average);
                System.out.println(Wallet.arrayList.get(j).name + " pays(2) " +
                        Wallet.arrayList.get(i).name + " " + (pay));
                Wallet.arrayList.get(i).amountSpent -= (pay);
                Wallet.arrayList.get(j).amountSpent += (pay);
                round(Wallet.arrayList.get(i).amountSpent);
                round(Wallet.arrayList.get(j).amountSpent);
            }
            if (round(Wallet.arrayList.get(i).amountSpent) == average){
                i--;
            }
            if (round(Wallet.arrayList.get(j).amountSpent) == average){
                j++;
            }

            counter--;
        }
        System.out.println("----------------");
        for (Wallet wallet : Wallet.arrayList) {
            System.out.println(wallet.name + ": " + wallet.amountSpent);
        }

    }
}

class Wallet {
    String name;
    double amountSpent;
    static ArrayList<Wallet> arrayList = new ArrayList();
    static double pot;
    static int numOfWallets;



    public Wallet(String name) {
        arrayList.add(this);
        this.name = name;
        this.amountSpent = 0;
        numOfWallets++;

    }

    public void buy(double dollars) {
        this.amountSpent += dollars;
        pot += dollars;
    }


}