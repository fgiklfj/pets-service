package infrastructure.reposimpl;

import domainmodel.entities.User;
import domainmodel.repointerfaces.UserRepo;

import java.util.HashMap;
import java.util.Map;

public class UserRepoImpl implements UserRepo {
    private final Map<String, User> userRepo = new HashMap<>();

    /**
     * Adds a new user to the repository.
     * The user is added to the repository with its name as the key.
     * @param newUser the new user to add
     */
    @Override
    public void addUser(User newUser) {
        userRepo.put(newUser.getName(), newUser);
    }

    /**
     * Retrieves a user by their name.
     * @param name the name of the user to retrieve
     * @return the user with the given name, or null if no such user exists
     */
    @Override
    public User getUserByName(String name) {
        return userRepo.get(name);
    }
}
