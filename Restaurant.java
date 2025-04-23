import java.util.*;
import java.io.*;

public class Restaurant implements HasMenu, Serializable {

    CustomerList customers = new CustomerList();
    transient Scanner scanner = new Scanner(System.in);

    public class CustomerList extends ArrayList<Customer> {

    }

    public static void main(String[] args){
		new Restaurant();
	}

    public Restaurant (){
        // Uncomment these to refresh data
        //this.loadSampleCustomers();
        //this.saveCustomers();

        this.loadCustomers();
        this.start();
        this.saveCustomers();
    }

    public void loadSampleCustomers(){
        customers.add(new Customer("Alice", "password"));
        customers.add(new Customer("Bob", "Password"));
        customers.add(new Customer("Cindy", "Passw0rd"));
    }

    public void saveCustomers(){
        try {
            FileOutputStream fo = new FileOutputStream("Customers.dat");
            ObjectOutputStream obOut = new ObjectOutputStream(fo);
            obOut.writeObject(customers);
            obOut.close();
            fo.close();
            } catch (IOException e) {
            System.out.println("Error saving customers.");
        }
    }
    
    public void loadCustomers() {
        try {
            FileInputStream fi = new FileInputStream("Customers.dat");
            ObjectInputStream obIn = new ObjectInputStream(fi);
            customers = (CustomerList) obIn.readObject();
            obIn.close();
            fi.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous customer data found. Loading sample data.");
            loadSampleCustomers();
        }
    }

    public void loginAsCustomer(){
        System.out.print("User Name: ");
        String userNameIn = scanner.nextLine();
        System.out.print("Password: ");
        String passwordIn = scanner.nextLine();

        Customer currentCustomer = null;
        for (Customer customer: customers){
            if (customer.login(userNameIn, passwordIn)){
                currentCustomer = customer;
            }
        }

        if (currentCustomer == null){
            System.out.println("Customer not found");
        } else {
            currentCustomer.start();
        }
    }

    public String menu() {
        return """
            Restaurant Menu
            0) Exit System
            1) Login as Customer
            2) Create new user
            Please enter 0-2: 
            
            """;
    }

    
    public void addUser() {
        System.out.print("Enter your name: ");
        String newUserName = scanner.nextLine();
        System.out.print("Enter your password: ");
        String newPassword = scanner.nextLine();

        Customer newCustomer = new Customer(newUserName, newPassword);
        customers.add(newCustomer);
        System.out.println("User added successfully.");
    }

    public void start() {
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.print(menu());
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                loginAsCustomer();
            } else if (choice.equals("2")) {
                addUser();
            } else if (choice.equals("0")) {
                System.out.println("Exiting system. Goodbye!");
                keepGoing = false;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}