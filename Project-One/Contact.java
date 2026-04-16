package contactservice;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    private void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
package contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
package contactservice.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import contactservice.Contact;
import contactservice.ContactService;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        assertNotNull(service.getContact("001"));
        assertEquals("John", service.getContact("001").getFirstName());
    }

    @Test
    public void testDuplicateIdNotAllowed() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("001", "John", "Smith", "1234567890", "123 Main St");
        Contact contact2 = new Contact("001", "Mike", "Jones", "0987654321", "456 Oak Ave");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("001");

        assertNull(service.getContact("001"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateContact("001", "Mike", "Jones", "0987654321", "456 Oak Ave");

        Contact updatedContact = service.getContact("001");
        assertEquals("Mike", updatedContact.getFirstName());
        assertEquals("Jones", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak Ave", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("999", "Mike", "Jones", "0987654321", "456 Oak Ave");
        });
    }

    @Test
    public void testUpdateWithInvalidPhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("001", "Mike", "Jones", "123", "456 Oak Ave");
        });
    }
}
