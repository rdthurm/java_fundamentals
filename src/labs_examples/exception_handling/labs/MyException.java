package labs_examples.exception_handling.labs;

public class MyException extends Exception {
    public String name = "More than 100";

    @Override
    public String toString(){
        return "More than 100! Oops!";
    }
}
