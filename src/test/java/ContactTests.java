import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTests {
    String name = "Лена";
    String phoneNumber = "8-888-888-88-88";

    @Test
    public void testEquals() {
        String name2 = "Петя";
        String phoneNumber2 = "8-888-888-88-88";
        Contact contact1 = new Contact(phoneNumber, name);
        Contact contact2 = new Contact(phoneNumber2, name2);

        boolean result = contact1.equals(contact2);

        Assertions.assertTrue(result);
    }

    @Test
    public void testToString() {
        Contact contact = new Contact(phoneNumber, name);
        String expected = name + " " + phoneNumber;

        String result = contact.toString();

        Assertions.assertEquals(expected, result);
    }
}
