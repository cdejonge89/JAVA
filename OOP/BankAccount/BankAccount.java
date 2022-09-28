import java.util.ArrayList;

public class BankAccount {
    // attributes
    private double checkingBal;
    private double savingsBal;
    // create a class memeber (belongs to the whole class, not individual instances)
    private static int numOfAccounts;
    private static int checkingTotal;
    private static int savingsTotal;

    // constructor
    public BankAccount() {
        // be sure to increment the account count
        numOfAccounts ++;  // no "this" for static variables
    }

    // getter (also methods)
    public double getCheckingBal(){
        return this.checkingBal;
    }
    public double getSavingsgBal(){
        return this.savingsBal;
    }

    public static int getNumOfAccounts(){
        return numOfAccounts;
    }
    public static int getCheckingTotal(){
        return checkingTotal;
    }
    public static int getSavingsTotal(){
        return savingsTotal;
    }

    // create a method to depost
    // public void depositAccount(double depositAccount) {
    //     this.checkingBal += depositAccount;
    //     this.savingsBal += depositAccount;
    //     accountTotal += depositAccount;
    // }

    public void depositChecking(double depositChecking) {
        this.checkingBal += depositChecking;
        checkingTotal += depositChecking;
    }

    public void depositSavings(double depositSavings) {
        this.savingsBal += depositSavings;
        savingsTotal += depositSavings;
    }


    // create a method to withdraw
    public void withdrawChecking(double withdrawChecking) {
        this.checkingBal -= withdrawChecking;
        checkingTotal -= withdrawChecking;
    }
    public void withdrawSavings(double withdrawSavings) {
        if(this.savingsBal < withdrawSavings) {
            System.out.println("You ran out of savings");
        } else {
            this.savingsBal -= withdrawSavings;
            savingsTotal -= withdrawSavings;
        }
    }


}