import java.util.*;
import java.io.*;

public class PurchaseManager implements HasMenu, Serializable {
    protected Customer customer;

    private String[] foodNames = {
        "Cheeseburger", "Pizza Pie", "Fries", "Chicken Salad", "Spicy Chicken Sandwich", "Chicken Strips", "Soda", "Water"
    };

    private double[] foodPrices = {
        5.99, 8.99, 1.99, 4.50, 3.99, 4.99, 1.75, 0.00
    };

    private List<Integer> order = new ArrayList<>();

    int viewOrderOption = foodNames.length + 1;
    int checkoutOption = foodNames.length + 2;
    // These ints allow for the checkout and view order options to move dynamically with the length of the menu.

    public PurchaseManager(Customer customer) {
        this.customer = customer;
    }

    public String menu() {
        StringBuilder sb = new StringBuilder("Food Menu:\n 0) Exit\n");
        for (int i = 0; i < foodNames.length; i++) {
            sb.append((i + 1) + ") " + foodNames[i] + " - $" + String.format("%.2f", foodPrices[i]) + "\n");
        }
        sb.append((foodNames.length + 1) ") View Order\n");
        sb.append((checkoutOption) + ") Checkout\n");
        sb.append("Choose an option: ");
        return sb.toString();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.print(menu());
            String input = scanner.nextLine();

            if (input.equals("0")) {
                keepGoing = false;
            } else if (input.equals(String.valueOf(viewOrderOption))) {
                viewOrder();
            } else if (input.equals(String.valueOf(checkoutOption))) {
                checkout();
            } else {
                int choice = -1;
                try {
                    choice = Integer.parseInt(input) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Try a number.");
                    continue;
                }

                if (choice >= 0 && choice < foodNames.length) {
                    order.add(choice);
                    System.out.println(foodNames[choice] + " added to order.");
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private void viewOrder() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        System.out.println("Items in your order:");
        double total = 0;
        for (int i : order) {
            System.out.println("- " + foodNames[i] + " ($" + String.format("%.2f", foodPrices[i]) + ")");
            total += foodPrices[i];
        }
        System.out.println("Total: $" + String.format("%.2f", total));
    }

    private void checkout() {
        if (order.isEmpty()) {
            System.out.println("Order is empty. Nothing to checkout.");
            return;
        }

        double total = 0;
        for (int i : order) {
            total += foodPrices[i];
        }

        System.out.println("Checkout total: $" + String.format("%.2f", total));
        if (customer.account.getBalance() >= total) {
            customer.account.setBalance(customer.account.getBalance() - total);
            System.out.println("Purchase successful! Remaining balance: " + customer.account.getBalanceString());
            order.clear();
        } else {
            System.out.println("Not enough balance to complete the purchase.");
        }
    }
}
