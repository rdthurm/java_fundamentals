package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Book extends Item {
    protected String author;
    protected boolean fiction;
    protected int numOfHardcover;

    public Book(int rentalPeriod, String author, String title, boolean fiction) {
        super(rentalPeriod, title);
        this.author = author;
        this.fiction = fiction;
        this.numOfHardcover = 0;
        this.stock = 0;
    }

    public void acquire(int num, boolean hardcover){
        this.addToStock(num);
        if (hardcover){
            this.numOfHardcover += num;
        }
    }

    public int getPaperback() {
        return stock - numOfHardcover;
    }

    public boolean isFiction() {
        return fiction;
    }

    public void setFiction(boolean fiction) {
        this.fiction = fiction;
    }

    public int getNumOfHardcover() {
        return numOfHardcover;
    }

    public void setNumOfHardcover(int numOfHardcover) {
        this.numOfHardcover = numOfHardcover;
    }
}
