package ReposImpl;

import RepoInterfaces.UserRepo;
import entities.User;

import java.util.HashMap;

public class UserRepoImpl implements UserRepo {

    private final HashMap<String, User> userRepo = new HashMap<String, User>();

    /**
     * @param newUser
     */
    @Override
    public void AddUser(User newUser) {
        userRepo.put(newUser.getName(), newUser);
    }

    /**
     * @param name
     * @return
     */
    @Override
    public User GetUserByName(String name) {
        return userRepo.get(name);
    }
}
