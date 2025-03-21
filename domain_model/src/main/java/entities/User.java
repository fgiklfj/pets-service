package entities;

import exceptions.InvalidUserNameException;
import exceptions.InvalidUserPasswordException;

import java.util.UUID;

public class User {
    private final UUID userId;
    private final String name;
    private final String password;


    public User(String name, String password) throws InvalidUserNameException, InvalidUserPasswordException {
        if (name.isEmpty())
            throw new InvalidUserNameException("Name can't be empty");

        if (password.isEmpty())
            throw new InvalidUserPasswordException("Password can't be empty");

        this.userId = UUID.randomUUID();
        this.name = name;
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean isPasswordMatch(String randomSymbols) {
        return password.equals(randomSymbols);
    }

}
