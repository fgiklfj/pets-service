package domainmodel.repointerfaces;

import domainmodel.entities.User;

public interface UserRepo {
    public void addUser(User newUser);

    public User getUserByName(String name);
}
