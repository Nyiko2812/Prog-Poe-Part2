
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public final class Message {
    private final String messageId;
    private static int messageCount = 0;
    private final int messageNumber;
    private final String recipient;
    private final String messageText;
    private final String messageHash;

    public Message(String recipient, String messageText) {
        this.messageId = generateMessageId();
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageNumber = ++messageCount;
        this.messageHash = createMessageHash();
    }

    Message() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String generateMessageId() {
        long number = (long) (Math.random() * 1_000_000_000L);
        return String.format("%010d", number);
    }

    public boolean checkMessageID() {
        return messageId.length() == 10;
    }

    public boolean checkRecipientCell() {
        // Validates South African number format: +27 followed by 9 digits
        return recipient != null && recipient.matches("^\\+27\\d{9}$");
    }

    public String createMessageHash() {
        if (messageText == null || messageText.trim().isEmpty()) {
            return "EMPTY:EMPTY";
        }
        String[] words = messageText.trim().split("\\s+");
        String first = words[0].toUpperCase();
        String last = words[words.length - 1].toUpperCase();
        return first + ":" + last;
    }

    // Getters
    public String getMessageId() {
        return messageId;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    // Convert message to JSON string
    public String toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("messageId", messageId);
        obj.put("messageNumber", messageNumber);
        obj.put("recipient", recipient);
        obj.put("messageText", messageText);
        obj.put("messageHash", messageHash);
        return obj.toString();
    }

    // Optionally write JSON to a file
    public void saveToFile(String filename) throws IOException {
        try (FileWriter file = new FileWriter(filename)) {
            file.write(toJSON());
        }
    }

    void setMessageNumber(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}