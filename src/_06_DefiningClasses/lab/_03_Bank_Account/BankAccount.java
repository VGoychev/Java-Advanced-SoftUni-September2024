package _06_DefiningClasses.lab._03_Bank_Account;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interest = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    BankAccount() {
        this.id = bankAccountCount;
        bankAccountCount++;
    }

    public int getId(){
        return id;
    }

    static void setInterestRate (double interest){
        BankAccount.interest = interest;
    }

    void deposit(double amount){
        this.balance += amount;
    }
    double getInterest(int years) {
        return BankAccount.interest * years * this.balance;
    }

    public void print(){
        System.out.println(String.format("Account ID%d created", getId()));
    }
}
