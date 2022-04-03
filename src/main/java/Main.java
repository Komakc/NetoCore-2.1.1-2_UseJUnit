public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        // Создание групп
        phoneBook.addGroup("Друзья");
        phoneBook.addGroup("Работа");
        phoneBook.addGroup("Курс");

        // Добавление контактов в группы
        phoneBook.addContactToGroup(new Contact("8-905-203-10-10", "Лена"), "Друзья");
        phoneBook.addContactToGroup(new Contact("8-917-305-89-11", "Коля"), "Друзья");
        phoneBook.addContactToGroup(new Contact("8-957-705-09-61", "Ника"), "Друзья");
        phoneBook.addContactToGroup(new Contact("8-957-705-09-61", "Ника"), "Работа");

        phoneBook.addContactToGroup(new Contact("8-957-705-09-61", "Ника"), "Работа");// Попытка дублирования контакта
        phoneBook.addContactToGroup(new Contact("8-957-705-09-61", "Вера"), "Работа");

        phoneBook.addContactToGroup(new Contact("8-927-323-22-32", "Вася"), "Работа");
        phoneBook.addContactToGroup(new Contact("8-937-654-78-45", "Петя"), "Работа");
        System.out.println();

        // Поиск контакта в группе
        System.out.println(phoneBook.findContactOnGroup("Лена", "Друзья"));
        System.out.println(phoneBook.findContactOnGroup("Лена", "Работа"));
        System.out.println();

        // Поиск контакта по номеру
        System.out.println(phoneBook.findContactByNumber("8-905-203-10-10"));
        System.out.println(phoneBook.findContactByNumber("8-945-206-45-87"));
        System.out.println();

        // Список контактов в группе
        System.out.println(phoneBook.getContactsFromGroup("Друзья"));
        System.out.println(phoneBook.getContactsFromGroup("Работа"));
        System.out.println(phoneBook.getContactsFromGroup("Курс"));

        System.out.println(phoneBook.orderGroup());
    }
}