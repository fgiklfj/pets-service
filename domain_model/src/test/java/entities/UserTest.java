package entities;

import exceptions.ATMExceptionDomainModel;
import exceptions.InvalidUserNameException;
import exceptions.InvalidUserPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() throws ATMExceptionDomainModel, NoSuchAlgorithmException {
        user = new User("JohnDoe", "securePassword123");
    }

    @Test
    void testUserCreationWithValidData() {
        assertDoesNotThrow(() -> {
            User validUser = new User("Alice", "password123");
            assertNotNull(validUser.getUserId());
            assertEquals("Alice", validUser.getName());
        });
    }

    @Test
    void testUserCreationWithEmptyNameThrowsException() {
        assertThrows(InvalidUserNameException.class, () -> new User("", "password123"),
                "Creating user with empty name should throw exception");
    }

    @Test
    void testUserCreationWithEmptyPasswordThrowsException() {
        assertThrows(InvalidUserPasswordException.class, () -> new User("John", ""),
                "Creating user with empty password should throw exception");
    }

    @Test
    void testPasswordMatchSuccess() throws NoSuchAlgorithmException {
        assertTrue(user.isPasswordMatch("securePassword123"),
                "Password should match the stored password");
    }

    @Test
    void testPasswordMatchFailure() throws NoSuchAlgorithmException {
        assertFalse(user.isPasswordMatch("wrongPassword"),
                "Incorrect password should return false");
    }
}
