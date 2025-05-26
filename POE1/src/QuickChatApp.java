import javax.swing.JOptionPane;
import java.util.ArrayList;

public class QuickChatApp {
    public static void main(String[] args) {
        boolean loggedIn = login();
        if (!loggedIn) {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        int messageLimit;
        try {
            messageLimit = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to enter?"));
            if (messageLimit <= 0) {
                JOptionPane.showMessageDialog(null, "Message limit must be positive. Exiting.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number entered. Exiting.");
            return;
        }

        int sentCount = 0;
        ArrayList<String> sentMessages = new ArrayList<>();

        while (true) {
            String input = JOptionPane.showInputDialog(
                "Choose an option:\n1) Send Message\n2) Show recently sent messages\n3) Quit");
            if (input == null) break; // User cancelled

            int option;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid option. Please enter 1, 2, or 3.");
                continue;
            }

            switch (option) {
                case 1:
                    if (sentCount >= messageLimit) {
                        JOptionPane.showMessageDialog(null, "Message limit reached.");
                        break;
                    }

                    String recipient = JOptionPane.showInputDialog("Enter recipient's cell number (e.g.,must start with 123456789):");
                    if (recipient == null || recipient.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Recipient cannot be empty.");
                        break;
                    }

                    String message = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
                    if (message == null || message.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Message cannot be empty.");
                        break;
                    }

                    if (message.length() > 250) {
                        JOptionPane.showMessageDialog(null, "Message exceeds 250 characters by " + (message.length() - 250) + ". Please rewrite.");
                        break;
                    }

                    // Store message in format: "To [recipient]: [message]"
                    sentMessages.add("To " + recipient + ": " + message);
                    sentCount++;

                    JOptionPane.showMessageDialog(null, "Message sent.");
                    break;

                case 2:
                    if (sentMessages.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No messages sent yet.");
                    } else {
                        // Join all messages into one string separated by new lines
                        StringBuilder allMessages = new StringBuilder("Recently sent messages:\n");
                        for (String msg : sentMessages) {
                            allMessages.append(msg).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, allMessages.toString());
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Goodbye Nyiko!");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1, 2, or 3.");
                    break;
            }
        }
    }

    public static boolean login() {
        // For now, simple placeholder that always logs in successfully
        // You can replace this with actual login dialog and validation
        return true;
    }
}
