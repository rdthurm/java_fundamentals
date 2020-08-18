package labs_examples.static_nonstatic.labs;

public class Earth {

    public static void main(String[] args) {
        construct();
    }

    public static void dig(){
        System.out.println("Digging");
    }

    public static void construct(){
        dig();
        System.out.println("and constructing");
        Earth earth = new Earth();
        earth.nameShovel();
        Sky.rain();
        Sky sky = new Sky();
        sky.flood();
    }

    public void nameShovel(){
        System.out.println("with a shovel from Sears.");
    }

    public void house(){
        System.out.println("which is where I live.");
    }

    public static void moreThoughts(){
        System.out.println("Ashes to ashes; dust to dust.");
    }

}
