package labs_examples.objects_classes_methods.labs.oop.D_my_oop;
import java.time.LocalDate;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {



    public static void main(String[] args) {
        ArrayList<String> inventory = new ArrayList<>();

        Book book1 = new Book(21, "Salinger, J.D.", "The Catcher in the Rye", true);
        book1.acquire(12, false);
        book1.acquire(2, true);
        Book book2 = new Book(21, "Hemingway, Ernest", "The Sun Also Rises", true);
        book2.acquire(3, false);
        DVD dvd1 = new DVD(7, "SHREK 2", "PG", 72);
        dvd1.acquire(15);
        inventory.add(book1.sortTitle);
        inventory.add(book2.sortTitle);
        inventory.add(dvd1.sortTitle);
        System.out.println(inventory.toString());

        // testing checkouts and ins
        System.out.println("SHREK 2 stock before: " + dvd1.stock);
        Renter Riley = new Renter(0001);
        Riley.checkout(dvd1);
        System.out.println("SHREK 2 stock after: " + dvd1.stock);
        Riley.checkout(book2);
        Riley.checkout(book2);
        Riley.checkout(book2);
        System.out.println("Hemingway stock: " + book2.stock);
        Riley.checkout(book2);
        Riley.checkin(book1);
        Riley.hold(book2);
        Riley.hold(book1);

        Renter Dillon = new Renter(0002);
        CD cd1 = new CD(21, "OK Computer", 1, 47);
        cd1.acquire(1);
        System.out.println("OK Computer stock = " + cd1.stock);
        Dillon.checkout(cd1);
        Riley.hold(cd1);
        Dillon.checkin(cd1);
        Riley.checkout(cd1);
        cd1.acquire(1);
        Dillon.checkout(cd1);
    }


}
