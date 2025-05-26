import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {
    public static void main(String[] args) {
        
        // Interactive Account Creation
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("\n--- Interactive Account Creation (Optional) ---");
        System.out.print("Enter your Username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter your Password: ");
        String enteredPassword = scanner.nextLine();

        System.out.print("Enter your South African Cellphone Number: ");
        String enteredCellNumber = scanner.nextLine();

        // Set the values using setter methods
        login.getUsername(enteredUsername);
        login.getPassword(enteredPassword);
        login.getCellNumber(enteredCellNumber);

        System.out.println("\n--- Account Creation Summary ---");
        // Use getters to retrieve the values
        System.out.println("Username: " + login.getUsername()); // Use getter for username
        System.out.println("CellNumber validation: " + login.getCellNumber(enteredCellNumber)); // Use getter for cell number
        System.out.println("Username Validation: " + login.validateUsername());
        System.out.println("Password Validation: " + login.validatePassword());
        System.out.println("Cell Number Validation: " + login.validateCellNumber());

        // Interactive Login
        System.out.println("\n--- Interactive Login (Optional) ---");
        System.out.print("Enter your Username to login: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter your Password to login: ");
        String loginPassword = scanner.nextLine();

        System.out.println("Login Results: " + login.login(loginUsername, loginPassword));

        scanner.close();
    }


    void setPassword(String password123) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


