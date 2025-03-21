package repointerfaces;

import entities.User;

public interface UserRepo {
    public void addUser(User newUser);

    public User getUserByName(String name);
}
