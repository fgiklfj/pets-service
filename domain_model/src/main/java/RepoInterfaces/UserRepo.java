package RepoInterfaces;

import entities.User;

import java.util.List;

public interface UserRepo {
    public void AddUser(User newUser);

    public void DeleteUser(User stupidUser);

    public User GetUser(String name);
}
