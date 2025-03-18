package entities;

import Exceptions.InvalidUserNameException;
import Exceptions.InvalidUserPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

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
        assertNotNull(validUser.getUser_id());
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
        assertTrue(user.IsPasswordMatch("securePassword123"),
                "Password should match the stored password");
    }

    @Test
    void testPasswordMatchFailure() {
        assertFalse(user.IsPasswordMatch("wrongPassword"),
                "Incorrect password should return false");
    }

    @Test
    void testToStringMethod() {
        String expectedOutput = "user{" +
                "user_id=" + user.getUser_id() +
                ", name=" + user.getName() +
                "}";
        assertEquals(expectedOutput, user.toString(), "toString() output should match expected format");
    }
}
