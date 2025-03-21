package infrastructure.reposimpl;

import domainmodel.entities.User;
import domainmodel.repointerfaces.UserRepo;

import java.util.HashMap;
import java.util.Map;

public class UserRepoImpl implements UserRepo {

    private final Map<String, User> userRepo = new HashMap<String, User>();

    /**
     * @param newUser
     */
    @Override
    public void addUser(User newUser) {
        userRepo.put(newUser.getName(), newUser);
    }

    /**
     * @param name
     * @return
     */
    @Override
    public User getUserByName(String name) {
        return userRepo.get(name);
    }
}
