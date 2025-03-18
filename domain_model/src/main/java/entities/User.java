package entities;

import Exceptions.InvalidUserNameException;
import Exceptions.InvalidUserPasswordException;

import java.util.UUID;

public class User {
    private final UUID user_id;
    private final String name;
    private final String password;


    public User(String name, String password) throws InvalidUserNameException, InvalidUserPasswordException {
        if (name.isEmpty())
            throw new InvalidUserNameException("Name can't be empty");

        if (password.isEmpty())
            throw new InvalidUserPasswordException("Password can't be empty");

        this.user_id = UUID.randomUUID();
        this.name = name;
        this.password = password;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public String getName(){
        return name;
    }

    public boolean IsPasswordMatch(String randomSymbols){
        return password.equals(randomSymbols);
    }

    @Override
    public String toString(){
        return "user{" +
                "user_id=" + user_id +
                ", name=" + name +
                "}";
    }
}
