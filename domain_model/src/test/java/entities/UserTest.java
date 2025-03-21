package entities;

import exceptions.InvalidUserNameException;
import exceptions.InvalidUserPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() throws InvalidUserNameException, InvalidUserPasswordException {
        user = new User("JohnDoe", "securePassword123");
    }

    @Test
    void testUserCreationWithValidData() throws InvalidUserNameException, InvalidUserPasswordException {
        User validUser = new User("Alice", "password123");
        assertNotNull(validUser.getUserId());
        assertEquals("Alice", validUser.getName());
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
    void testPasswordMatchSuccess() {
        assertTrue(user.isPasswordMatch("securePassword123"),
                "Password should match the stored password");
    }

    @Test
    void testPasswordMatchFailure() {
        assertFalse(user.isPasswordMatch("wrongPassword"),
                "Incorrect password should return false");
    }
}
