import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    private String username;
    private String password;
    private String cellNumber;

    // Setter methods to assign values to the fields
    public void getUsername(String enteredUsername) {
        this.username = enteredUsername;
    }

    public void getPassword(String enteredPassword) {
        this.password = enteredPassword;
    }

    public boolean getCellNumber(String enteredCellNumber) {
        this.cellNumber = enteredCellNumber;
        return false;
    }

    // Getter methods to retrieve values
    public String getUsername() {
        return this.username;
    }

    public String getCellNumber() {
        return this.cellNumber;
    }

    // Username Validation
    public String validateUsername() {
        if (username.contains("_") && username.length() >= 5 && !username.startsWith("_") && !username.endsWith("_")) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted. Ensure it contains an underscore and is at least 5 characters in length.";
        }
    }

    // Password Validation
    public String validatePassword() {
        if (password.length() >= 8 &&
            password.matches(".*[A-Z].*") && // at least one uppercase letter
            password.matches(".*[a-z].*") && // at least one lowercase letter
            password.matches(".*\\d.*") &&   // at least one digit
            password.matches(".*[!@#%^&()_+=\\-].*")) { // at least one special character
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted. Ensure it is at least 8 characters long and contains at least one uppercase letter, one lowercase letter, one digit, and one special character.";
        }
    }

    // Cell Number Validation (South African format)
    public String validateCellNumber() {
        Pattern pattern = Pattern.compile("0\\d{9}$");
        Matcher matcher = pattern.matcher(this.cellNumber);

        if (matcher.matches()) {
            return "Cell phone number successfully added.";
        } else {
            return "Incorrect cellphone format. Ensure it follows the South African format (e.g., 0821234567).";
        }
    }

    // Login Method
    public String login(String enteredUsername, String enteredPassword) {
        if (this.username.equals(enteredUsername) && this.password.equals(enteredPassword)) {
            String[] nameParts = this.username.split("_");
            String firstName = nameParts[0];
            String lastName = (nameParts.length > 1) ? nameParts[1] : "User";
            return "Welcome " + firstName + " " + lastName + "! It's great to see you again.";
        } else {
            return "Username or password incorrect. Please try again.";
        }
    }
}

