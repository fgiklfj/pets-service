package domainmodel.entities;

import domainmodel.exceptions.ATMExceptionDomainModel;
import domainmodel.exceptions.InvalidUserNameException;
import domainmodel.exceptions.InvalidUserPasswordException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class User {
    private final UUID userId;
    private final String name;
    private final String hashedPassword;


    public User(String name, String password) throws ATMExceptionDomainModel, NoSuchAlgorithmException {
        if (name.isEmpty())
            throw new InvalidUserNameException("Name can't be empty");

        if (password.isEmpty())
            throw new InvalidUserPasswordException("Password can't be empty");

        this.userId = UUID.randomUUID();
        this.name = name;
        this.hashedPassword = getHashedPassword(password);
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return the id of the user.
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return the name of the user as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Compares the given random symbols with the stored hashed password.
     * This method is used for login validation.
     *
     * @param randomSymbols the symbols to compare with the stored password
     * @return true if the given symbols match the stored password, false otherwise
     * @throws NoSuchAlgorithmException if the hashing algorithm is unavailable
     */
    public boolean isPasswordMatch(String randomSymbols) throws NoSuchAlgorithmException {
        return hashedPassword.equals(getHashedPassword(randomSymbols));
    }

    /**
     * Takes a string, hashes it using SHA-256, and then encodes the hash in
     * Base64.
     *
     * @param hashedPassword the string to hash
     * @return the Base64 encoded hash of the string
     * @throws NoSuchAlgorithmException if the SHA-256 algorithm is not available
     */
    private String getHashedPassword(String hashedPassword) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(hashedPassword.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    /**
     * Returns a string representation of the user object. The format includes
     * the user's unique identifier and name, providing a concise and readable
     * summary of the user's data.
     *
     * @return a string representation of the user
     */
    @Override
    public String toString() {
        return "user{user_id=" + userId + ", name=" + name + "}";
    }
}
