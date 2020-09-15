package labs_examples.packages.labs.two;


import labs_examples.packages.labs.one.BankOne;

public class BankTwo extends BankOne {

    void bankTwoName(){
        System.out.println("Bank two name");
    }

    void reportBothBanks(){
        System.out.println("Bank two balance");
        reportBankOne(); // this works since BankTwo extends BankOne, where this method is declared
        // bankOneName(); // this won't work because bankOneName() is not accessible
    }

}
