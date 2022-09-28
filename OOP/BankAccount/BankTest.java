class BankTest {
    public static void main(String[] args) {
        System.out.println("----- Bank Test -----");
        System.out.println("Total Accounts: " + BankAccount.getNumOfAccounts());
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount();
        BankAccount a3 = new BankAccount();

        a1.depositChecking(1000);
        a2.depositChecking(2000);
        System.out.println("a1 Balance: " + a1.getCheckingBal());

        a2.depositSavings(500);
        a3.depositSavings(400);

        a3.withdrawSavings(100);
        a3.withdrawSavings(400);

        System.out.println("Total Accounts: " + BankAccount.getNumOfAccounts());
        System.out.println("Total Checking: " + BankAccount.getCheckingTotal());
        System.out.println("Total Savings: " + BankAccount.getSavingsTotal());
    }
}