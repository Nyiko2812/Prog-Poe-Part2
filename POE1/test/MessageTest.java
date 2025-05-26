/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class MessageTest {

   @Test
    public void testCheckMessageID() {
        Message message = new Message("+27831234567", "Hi");
        assertTrue(message.checkMessageID());
        assertEquals(10, message.getMessageId().length());
    }

    @Test
    public void testCheckRecipientCell_Valid() {
        Message message = new Message("+27831234567", "Test");
        assertTrue(message.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_Invalid() {
        Message message = new Message("0831234567", "Test");
        assertFalse(message.checkRecipientCell());
    }

    @Test
    public void testCreateMessageHash() {
        Message message = new Message("+27831234567", "Hello world");
        assertEquals("HELLO:WORLD", message.createMessageHash());
    }

    @Test
    public void testEmptyMessageHash() {
        Message message = new Message("+27831234567", "   ");
        assertEquals("EMPTY:EMPTY", message.createMessageHash());
    }

    @Test
    public void testToJSON() {
        Message message = new Message("+27831234567", "Hello world");
        String json = message.toJSON();
        assertTrue(json.contains("\"recipient\""));
        assertTrue(json.contains("\"messageText\""));
    }

    @Test
    public void testSaveToFile() throws IOException {
        Message message = new Message("+27831234567", "Test message");
        String filename = "test_message.json";

        message.saveToFile(filename);

        File file = new File(filename);
        assertTrue(file.exists());

        String content = Files.readString(file.toPath());
        assertTrue(content.contains("Test message"));

        // Clean up
        file.delete();
    }
}
