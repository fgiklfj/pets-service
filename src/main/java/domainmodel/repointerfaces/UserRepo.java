package domainmodel.repointerfaces;

import domainmodel.entities.User;

public interface UserRepo {

    /**
     * Adds a new user to the repository.
     * The user is added to the repository with its name as the key.
     * @param newUser the new user to add
     */
    void addUser(User newUser);

    /**
     * Retrieves a user by their name.
     * @param name the name of the user to retrieve
     * @return the user with the given name, or null if no such user exists
     */
    User getUserByName(String name);
}