import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PhoneBookTests {
    PhoneBook sut;

    @BeforeEach
    public void init() {
        sut = new PhoneBook();
    }
    @Test // №1
    public void testAddGroup() {
        String group = "focusGroup";
        PhoneBook expected = new PhoneBook();
        expected.phoneBook.put(group, new ArrayList<>());

        sut.addGroup(group);

        Assertions.assertEquals(expected.phoneBook, sut.phoneBook);
    }


    @Test
    public void testAddContactToGroup() {
        String group = "focusGroup";
        Contact contact = new Contact("8-888-888-88-88", "Лена");
        List<Contact> list = new ArrayList<>();
        list.add(contact);
        PhoneBook expected = new PhoneBook();
        expected.phoneBook.put(group, new ArrayList<>(list));

        sut.addGroup(group);
        sut.addContactToGroup(contact, group);

        Assertions.assertEquals(expected.phoneBook, sut.phoneBook);
    }

    @Test // №2
    public void testAddContactToGroup_ContactExists() {
        String group = "focusGroup";
        Contact contact = new Contact("8-888-888-88-88", "Лена");
        List<Contact> list = new ArrayList<>();
        list.add(contact);
        PhoneBook expected = new PhoneBook();
        expected.phoneBook.put(group, new ArrayList<>(list));

        sut.addGroup(group);
        sut.addContactToGroup(contact, group);
        sut.addContactToGroup(contact, group);//Попытка добавления уже существующего контакта

        Assertions.assertEquals(expected.phoneBook, sut.phoneBook);
    }

    @Test // №3
    public void testOrderGroup() {
        String group1 = "focusGroup";
        String group2 = "testGroup";
        sut.addGroup(group1);
        sut.addGroup(group2);
        String expected = "Список групп:\n" + group1 + "\n" + group2 + "\n";

        String result = sut.orderGroup();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetContactFromGroup() {
        String group = "focusGroup";
        Contact contact1 = new Contact("8-888-888-88-88", "Лена");
        Contact contact2 = new Contact("8-444-444-44-44", "Петя");
        sut.addGroup(group);
        sut.addContactToGroup(contact1, group);
        sut.addContactToGroup(contact2, group);
        String expected = "Список контактов в группе " + group + ":\n"
                + "Лена 8-888-888-88-88\n"
                + "Петя 8-444-444-44-44\n";

        String result = sut.getContactsFromGroup(group);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetContactsFromGroup_isEmpty() {
        String group = "focusGroup";
        sut.addGroup(group);
        String expected = "Список контактов в группе focusGroup:\n" + "Список пуст\n";

        String result = sut.getContactsFromGroup(group);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindContactOnGroup() {
        String group = "focusGroup";
        String phoneNumber = "8-888-888-88-88";
        String name = "Лена";
        Contact contact = new Contact(phoneNumber, name);
        sut.addGroup(group);
        sut.addContactToGroup(contact, group);
        String expected = "Контакт " + name + " есть в группе " + group;

        String result = sut.findContactOnGroup(name, group);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindContactOnGroup_isNot() {
        String group = "focusGroup";
        String phoneNumber1 = "8-888-888-88-88";
        String name1 = "Лена";
        String name2 = "Петя";
        Contact contact = new Contact(phoneNumber1, name1);
        sut.addGroup(group);
        sut.addContactToGroup(contact, group);
        String expected = "Контакта " + name2 + " нет в группе " + group;

        String result = sut.findContactOnGroup(name2, group);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindContactByNumber() {
        String group = "focusGroup";
        String phoneNumber = "8-888-888-88-88";
        String name = "Лена";
        Contact contact = new Contact(phoneNumber, name);
        sut.addGroup(group);
        sut.addContactToGroup(contact, group);
        String expected  = phoneNumber + " " + name;

        String result = sut.findContactByNumber(phoneNumber);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindContactByNumber_isNot() {
        String group = "focusGroup";
        String phoneNumber = "8-888-888-88-88";
        String name = "Лена";
        String phoneNumberTest ="8-444-444-44-44";
        Contact contact = new Contact(phoneNumber, name);
        sut.addGroup(group);
        sut.addContactToGroup(contact, group);
        String expected  = "Контакт по номеру " + phoneNumberTest + " не найден";

        String result = sut.findContactByNumber(phoneNumberTest);

        Assertions.assertEquals(expected, result);
    }
}
