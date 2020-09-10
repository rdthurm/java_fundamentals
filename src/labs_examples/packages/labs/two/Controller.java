package labs_examples.packages.labs.two;

import labs_examples.packages.labs.one.BankOne;

public class Controller {
    public static void main(String[] args) {
        BankOne bankOne = new BankOne();
        bankOne.reportBankOne(); // this won't work since reportBankOne() is not accessible in a different package
        BankTwo bankTwo = new BankTwo();
        bankTwo.reportBothBanks();
    }
}
