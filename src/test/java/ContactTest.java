import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {
    @Test
    public void testEquals() {
        String name1 = "Лена";
        String phoneNumber1 = "8-888-888-88-88";
        String name2 = "Петя";
        String phoneNumber2 = "8-888-888-88-88";
        Contact contact1 = new Contact(phoneNumber1, name1);
        Contact contact2 = new Contact(phoneNumber2, name2);

        boolean result = contact1.equals(contact2);

        Assertions.assertTrue(result);
    }

    @Test
    public void testToString() {
        String name = "Лена";
        String phoneNumber = "8-888-888-88-88";
        Contact contact = new Contact(phoneNumber, name);

        String expected = name + " " + phoneNumber;

        String result = contact.toString();

        Assertions.assertEquals(expected, result);
    }
}
