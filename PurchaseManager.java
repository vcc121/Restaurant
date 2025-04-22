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

    public PurchaseManager(Customer customer) {
        this.customer = customer;
    }
}