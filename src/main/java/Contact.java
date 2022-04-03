public class Contact {
    String phoneNumber;
    String name;

    public Contact(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public String toString() {
        return name + " " + phoneNumber;
    }
}