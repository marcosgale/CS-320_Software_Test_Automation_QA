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
