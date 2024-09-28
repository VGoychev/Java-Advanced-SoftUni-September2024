package _06_DefiningClasses.lab._03_Bank_Account;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Integer, BankAccount> bank = new LinkedHashMap<>();
        while (!input.equals("End")){
            String[] tokens = input.split(" ");
            switch (tokens[0]){
                case "Create":
                   create(bank);
                   break;
                case "Deposit":
                    deposit(tokens, bank);
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest":
                    getInterest(tokens,bank);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void create(Map<Integer, BankAccount> bank){
        BankAccount bankAccount = new BankAccount();
        bank.put(bankAccount.getId(), bankAccount);
        bankAccount.print();
    }
    private static void deposit(String[] tokens, Map<Integer, BankAccount> bank){
        int id = Integer.parseInt(tokens[1]);
        double amount = Double.parseDouble(tokens[2]);
        BankAccount bankAccount = bank.get(id);

        if (bankAccount != null){
            bankAccount.deposit(amount);
            System.out.printf("Deposited %.0f to ID%d%n", amount, id);
        } else {
            System.out.println("Account does not exist");
        }
    }
    private static void setInterest(double interest){
        BankAccount.setInterestRate(interest);
    }
    private static void getInterest(String[] tokens, Map<Integer, BankAccount> bank){
        int id = Integer.parseInt(tokens[1]);
        int years = Integer.parseInt(tokens[2]);
        BankAccount bankAccount = bank.get(id);

        if (bankAccount != null){
            System.out.printf("%.2f%n", bankAccount.getInterest(years));
        } else {
            System.out.println("Account does not exist");
        }
    }
}
