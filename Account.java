import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class Account implements HasMenu, Serializable {
    double balance;
    
    public Account() {
        this.balance = 0.0;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        Account a = new Account();
        a.start();
    }

    public String menu() {
        return """
            Account Menu
            0) Quit
            1) Check Balance
            2) Make a Deposit
            Please enter 0-2: 
            
            """;
    }
    
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.print(menu());
            String response = scanner.nextLine();
            
            if (response.equals("0")) {
                keepGoing = false;
            } 
            else if (response.equals("1")) {
                System.out.println("Checking balance...");
                this.checkBalance();
            } 
            else if (response.equals("2")) {
                System.out.println("Making a deposit...");
                this.makeDeposit();
            }
            else {
                System.out.println("Invalid input.");
            }
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getBalanceString() {
        return String.format("$%.2f", this.balance);
    }

    public void checkBalance() {
        System.out.println("Current balance: " + this.getBalanceString());
    }

    private double getDouble() {
        Scanner input = new Scanner(System.in);
        String sResult = input.nextLine();
        double result = 0d;
        try {
            result = Double.parseDouble(sResult);
        } 
        catch (Exception e) {
            System.out.println("Not a legal input. Changing to zero.");
            result = 0d;
        }
        return result;
    }

    public void makeDeposit() {
        System.out.print("How much to deposit? ");
        double amount = getDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("New balance: " + getBalanceString());
        } else {
            System.out.println("Deposit failed. Invalid amount.");
        }
    }
}