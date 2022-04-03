import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PhoneBookTest {
    //Использование Hamcrest
    @Test
    public void testAddGroup() {
        String group = "focusGroup";

        PhoneBook expected = new PhoneBook();
        expected.phoneBook.put(group, new ArrayList<>());

        PhoneBook result = new PhoneBook();
        result.addGroup(group);

        assertThat(expected.phoneBook, hasEntry(group, new ArrayList<>()));
    }


    @Test
    public void testAddContactToGroup() {
        String group = "focusGroup";
        Contact contact = new Contact("8-888-888-88-88", "Лена");
        List<Contact> list = new ArrayList<>();
        list.add(contact);

        PhoneBook expected = new PhoneBook();
        expected.phoneBook.put(group, new ArrayList<>(list));

        PhoneBook result = new PhoneBook();
        result.addGroup(group);
        result.addContactToGroup(contact, group);

        Assertions.assertEquals(expected.phoneBook, result.phoneBook);
    }

    @Test
    public void testAddContactToGroup_ContactExists() {
        String group = "focusGroup";
        Contact contact = new Contact("8-888-888-88-88", "Лена");
        List<Contact> list = new ArrayList<>();
        list.add(contact);

        PhoneBook expected = new PhoneBook();
        expected.phoneBook.put(group, new ArrayList<>(list));

        PhoneBook result = new PhoneBook();
        result.addGroup(group);
        result.addContactToGroup(contact, group);
        result.addContactToGroup(contact, group);//Попытка добавления уже существующего контакта

        Assertions.assertEquals(expected.phoneBook, result.phoneBook);
    }

    //Использование Hamcrest
    @Test
    public void testOrderGroup() {
        String group1 = "focusGroup";
        String group2 = "testGroup";
        PhoneBook groups = new PhoneBook();
        groups.addGroup(group1);
        groups.addGroup(group2);

        String expected = "Список групп:\n" + group1 + "\n" + group2 + "\n";

        String result = groups.orderGroup();

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testGetContactFromGroup() {
        String group = "focusGroup";
        Contact contact1 = new Contact("8-888-888-88-88", "Лена");
        Contact contact2 = new Contact("8-444-444-44-44", "Петя");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addGroup(group);
        phoneBook.addContactToGroup(contact1, group);
        phoneBook.addContactToGroup(contact2, group);

        String expected = "Список контактов в группе " + group + ":\n"
                + "Лена 8-888-888-88-88\n"
                + "Петя 8-444-444-44-44\n";

        String result = phoneBook.getContactsFromGroup(group);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetContactsFromGroup_isEmpty() {
        String group = "focusGroup";
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addGroup(group);

        String expected = "Список контактов в группе focusGroup:\n" + "Список пуст\n";

        String result = phoneBook.getContactsFromGroup(group);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindContactOnGroup() {
        String group = "focusGroup";
        String phoneNumber = "8-888-888-88-88";
        String name = "Лена";
        Contact contact = new Contact(phoneNumber, name);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addGroup(group);
        phoneBook.addContactToGroup(contact, group);

        String expected = "Контакт " + name + " есть в группе " + group;

        String result = phoneBook.findContactOnGroup(name, group);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindContactOnGroup_isNot() {
        String group = "focusGroup";
        String phoneNumber1 = "8-888-888-88-88";
        String name1 = "Лена";
        String name2 = "Петя";
        Contact contact = new Contact(phoneNumber1, name1);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addGroup(group);
        phoneBook.addContactToGroup(contact, group);

        String expected = "Контакта " + name2 + " нет в группе " + group;

        String result = phoneBook.findContactOnGroup(name2, group);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindContactByNumber() {
        String group = "focusGroup";
        String phoneNumber = "8-888-888-88-88";
        String name = "Лена";
        Contact contact = new Contact(phoneNumber, name);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addGroup(group);
        phoneBook.addContactToGroup(contact, group);

        String expected  = phoneNumber + " " + name;

        String result = phoneBook.findContactByNumber(phoneNumber);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindContactByNumber_isNot() {
        String group = "focusGroup";
        String phoneNumber = "8-888-888-88-88";
        String name = "Лена";
        String phoneNumberTest ="8-444-444-44-44";
        Contact contact = new Contact(phoneNumber, name);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addGroup(group);
        phoneBook.addContactToGroup(contact, group);

        String expected  = "Контакт по номеру " + phoneNumberTest + " не найден";

        String result = phoneBook.findContactByNumber(phoneNumberTest);

        Assertions.assertEquals(expected, result);
    }
}
