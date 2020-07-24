package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

/**
 * Run the class below and study the output. What prints and why?
 *
 * Your answer: 10 prints because int i was declared in class A which came before class B, so class B doesn't seem to
 * have authority to override int i. However, I have up to this point not seen a mismatch between the class that comes
 * before the object name (A in this case) and the class that comes after the "new" keyword (B in this case).
 * So I am not totally sure what's going on here.
 *
 */
class A {
    int i = 10;
}

class B extends A{
    int i = 20;
}

public class Exercise_02 {

    public static void main(String[] args) {
        A a = new B();

        System.out.println(a.i);
    }
}