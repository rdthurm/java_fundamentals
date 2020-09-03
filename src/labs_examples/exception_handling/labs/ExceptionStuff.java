package labs_examples.exception_handling.labs;

import java.awt.datatransfer.MimeTypeParseException;

public class ExceptionStuff {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            int x = a / b;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index exception");
        } catch (ArithmeticException ee){
            System.out.println("Math prob");
        } catch (Exception eee){
            System.out.println("Other exception");
        } finally {
            System.out.println("We done");
        }

        int[] ints = {1, 2, 3, 0};
        try {
            int y = ints[1] / ints[3];
            try {
                int z = ints[10];
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.toString());
            }
        } catch (ArithmeticException e){
            System.out.println(e.toString());
        } catch (Exception e){
            System.out.println(e.toString());
        }

        try {
            math();
        } catch (ArithmeticException e){
            System.out.println("Can't divide by zero, babe");
        }

        try {
            hundredcheck(200);
        } catch (MyException e){
            System.out.println(e.toString());
        }
    }

    public static void math() throws ArithmeticException{
        divide(10, 0);
    }

    public static void divide(int a, int b) throws ArithmeticException {
        System.out.println(a / b);
    }

  public static void hundredcheck(int num) throws MyException {
        if (num > 100){
            throw new MyException();
        }
  }
}
