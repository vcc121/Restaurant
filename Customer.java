import java.util.*;
import java.io.*;

public class Customer extends User {
    protected Account checking;

    public Customer(String userName, String password) {
        super(userName, password);
        this.account = new Account();
    }


    public static void main(String[] args) {
        Customer customer = new Customer("Alice", "1111");
        if (customer.login()) {
            System.out.println("Login Successful");
            customer.start();
        } else {
            System.out.println("Login Failed. Try again.");
        }
    }

    public String menu() {
        return """
            Account Menu
            0) Exit
            1) Manage Account
            2) Get some eats!
            3) Change password
            Please enter 0-3: 
            """;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.print(menu());
            int choice = scanner.nextInt();
            if (choice == 1) {
                account.start();
            } else if (choice == 2) {
                purchaseManager.start();
            } else if (choice == 3) {
                changePassword();
            } else if (choice == 0) {
                keepGoing = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void changePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new password: ");
        this.setPassword(scanner.nextLine());
        System.out.println("Password changed successfully.");
    }

    public String getReport(){
        String report = "User: " + this.getUserName();
        report += ", Account: " + this.account.getBalanceString();

        return report;
    }

}
