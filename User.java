import java.util.*;
import java.io.*;

public abstract class User implements HasMenu, Serializable {
    String userName = "";
    String password = "";

    public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
    }

    public boolean login(){
        Scanner input = new Scanner(System.in);
        boolean result = false;
        System.out.print("User name: ");
        String userNameIn = input.nextLine();

        if (userNameIn.equals(this.userName)){
            System.out.print("Password: ");
            String passwordIn = input.nextLine();

            if (passwordIn.equals(this.password)){
                result = true;
                System.out.println("Login successful!");
            }
            else {
                System.out.println("Login failed. Incorrect password.");
            }
        }
        else {
            System.out.println("Login failed. User name not found.");
        }
        return result;
    }
    
    public boolean login(String userNameIn, String passwordIn){
        boolean result = false;
        if (userNameIn.equals(this.userName)){
            if (passwordIn.equals(this.password)){
                result = true;
            }
        }
        return result;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}