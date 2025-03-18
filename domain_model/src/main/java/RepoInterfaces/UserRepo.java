package RepoInterfaces;

import entities.User;

public interface UserRepo {
    public void AddUser(User newUser);

    public User GetUserByName(String name);
}
