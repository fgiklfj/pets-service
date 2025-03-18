package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID user_id;
    private final String name;
    private final Type user_type;
    private final List<Account> accounts;

    public enum Type{
        ADMIN, USER
    }

    //todo: write exceptions with filling user's data

    public User(String name, Type user_type){
        this.user_id = UUID.randomUUID();
        this.name = name;
        this.user_type = user_type;
        this.accounts = new ArrayList<>();
    }

    public UUID getUser_id() {
        return user_id;
    }

    public String getName(){
        return name;
    }

    public Type getUser_type(){
        return user_type;
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    @Override
    public String toString(){
        return "user{" +
                "user_id=" + user_id +
                ", name=" + name +
                ", user_type=" + user_type +
                ", accounts=" + accounts +
                "}";
    }
}
