package entities;

import exceptions.ATMExceptionDomainModel;
import exceptions.InvalidUserNameException;
import exceptions.InvalidUserPasswordException;

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

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean isPasswordMatch(String randomSymbols) throws NoSuchAlgorithmException {
        return hashedPassword.equals(getHashedPassword(randomSymbols));
    }

    private String getHashedPassword(String hashedPassword) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(hashedPassword.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    @Override
    public String toString(){
        return "user{" +
                "user_id=" + userId +
                ", name=" + name +
                "}";
    }

}
