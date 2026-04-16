package contactservice.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import contactservice.Contact;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Smith", "1234567890", "123 Main St");

        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Smith", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Smith", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Smith", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Christopher", "Smith", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Christopher", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", null, "123 Main St");
        });
    }

    @Test
    public void testPhoneMustBeExactly10Digits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "12345", "123 Main St");
        });
    }

    @Test
    public void testPhoneMustContainOnlyDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "12345abcde", "123 Main St");
        });
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "1234567890", null);
        });
    }

    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("123", "John", "Smith", "1234567890", "123 Main St");
        contact.setFirstName("Mike");
        assertEquals("Mike", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("123", "John", "Smith", "1234567890", "123 Main St");
        contact.setLastName("Jones");
        assertEquals("Jones", contact.getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("123", "John", "Smith", "1234567890", "123 Main St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("123", "John", "Smith", "1234567890", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }
}
