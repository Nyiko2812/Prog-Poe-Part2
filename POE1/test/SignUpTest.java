/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SignUpTest {

    private SignUp signUp;

    // Initialize SignUp object before each test
    @Before
    public void setUp() {
        signUp = new SignUp();
    }

    // Test for valid username
    @Test
    public void testValidUsername() {
        signUp.setUsername("john_doe");
        String result = signUp.validateUsername();
        assertEquals("Username successfully captured.", result);
    }

    // Test for invalid username (missing underscore)
    @Test
    public void testInvalidUsernameMissingUnderscore() {
        signUp.setUsername("johndoe");
        String result = signUp.validateUsername();
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is at least 5 characters in length.", result);
    }

    // Test for invalid username (too short)
    @Test
    public void testInvalidUsernameTooShort() {
        signUp.setUsername("jd");
        String result = signUp.validateUsername();
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is at least 5 characters in length.", result);
    }

    // Test for valid password
    @Test
    public void testValidPassword() {
        signUp.setPassword("Password123!");
        String result = signUp.validatePassword();
        assertEquals("Password successfully captured.", result);
    }

    // Test for invalid password (too short)
    @Test
    public void testInvalidPasswordTooShort() {
        signUp.setPassword("Pass1!");
        String result = signUp.validatePassword();
        assertEquals("Password is not correctly formatted; please ensure that your password is at least 8 characters long and contains at least one uppercase letter, one lowercase letter, one digit, and one special character.", result);
    }

    // Test for invalid password (missing special character)
    @Test
    public void testInvalidPasswordNoSpecialChar() {
        signUp.setPassword("Password123");
        String result = signUp.validatePassword();
        assertEquals("Password is not correctly formatted; please ensure that your password is at least 8 characters long and contains at least one uppercase letter, one lowercase letter, one digit, and one special character.", result);
    }

    // Test for valid cellphone number
    @Test
    public void testValidCellNumber() {
        signUp.setCellNumber("0123456789");
        String result = signUp.validateCellNumber();
        assertEquals("Cell phone number successfully added.", result);
    }

    // Test for invalid cellphone number (incorrect format)
    @Test
    public void testInvalidCellNumber() {
        signUp.setCellNumber("1234567890");
        String result = signUp.validateCellNumber();
        assertEquals("Incorrect cellphone format.", result);
    }

    // Test for successful login
    @Test
    public void testLoginSuccess() {
        signUp.setUsername("john_doe");
        signUp.setPassword("Password123!");
        signUp.setCellNumber("0123456789");

        String result = signUp.login("john_doe", "Password123!");
        assertEquals("Welcome john doe! It's great to see you again.", result);
    }

    // Test for unsuccessful login (incorrect password)
    @Test
    public void testLoginFailureIncorrectPassword() {
        signUp.setUsername("john_doe");
        signUp.setPassword("Password123!");
        signUp.setCellNumber("0123456789");

        String result = signUp.login("john_doe", "WrongPassword");
        assertEquals("Username or password incorrect. Please try again.", result);
    }

    // Test for unsuccessful login (incorrect username)
    @Test
    public void testLoginFailureIncorrectUsername() {
        signUp.setUsername("john_doe");
        signUp.setPassword("Password123!");
        signUp.setCellNumber("0123456789");

        String result = signUp.login("incorrect_username", "Password123!");
        assertEquals("Username or password incorrect. Please try again.", result);
    }
}

