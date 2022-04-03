import java.util.*;

public class PhoneBook {
    Map<String, List<Contact>> phoneBook = new HashMap<>();

    void addGroup(String group) {
        phoneBook.put(group, new ArrayList<>());
    }

    void addContactToGroup(Contact contact, String group) {
        List<Contact> contacts = phoneBook.get(group);
        if (contacts.contains(contact)) {
            System.out.println("Контакт с номером " + contact.phoneNumber + " уже есть в группе " + group);
            return;
        }
        contacts.add(contact);
        System.out.println("Контак " + contact.name + " добавлен в группу " + group);
        phoneBook.put(group, contacts);
    }

    public String orderGroup() {
        String listGroups = "";
        for (String s : phoneBook.keySet()) {
            listGroups += s + "\n";
        }
        return "Список групп:\n" + listGroups;
    }

    public String getContactsFromGroup(String group) {
        List<Contact> contacts = phoneBook.get(group);
        StringBuilder list = new StringBuilder();
        list.append("Список контактов в группе ").append(group).append(":\n");
        if (contacts.isEmpty()) {
            list.append("Список пуст" + "\n");
            return list.toString();
        }
        for (Contact contact : contacts) {
            list.append(contact.toString()).append("\n");
        }

        return list.toString();
    }

    public String findContactOnGroup(String name, String group) {
        List<Contact> list = phoneBook.get(group);
        for (Contact contact : list) {
            if (contact.name.equals(name)) {
                return "Контакт " + name + " есть в группе " + group;
            }
        }
        return "Контакта " + name + " нет в группе " + group;
    }

    public String findContactByNumber(String number) {
        for (String s : phoneBook.keySet()) {
            List<Contact> contacts = phoneBook.get(s);
            for (Contact contact : contacts) {
                if (contact.phoneNumber.equals(number)) {
                    return number + " " + contact.name;
                }
            }
        }
        return "Контакт по номеру " + number + " не найден";
    }
}