package Services;

import Exceptions.*;
import RepoInterfaces.UserRepo;
import entities.User;

public class UserService {
    private final UserRepo userRepo;


    public UserService(UserRepo repo) {
        userRepo = repo;
    }

    public void Registration(String name, String password) throws InvalidUserNameException, InvalidUserPasswordException, UserAlreadyExistsException {
        if (userRepo.GetUserByName(name) != null) {
            throw new UserAlreadyExistsException("User with this name already exists");
        }

        User coolUser = new User(name, password);
        userRepo.AddUser(coolUser);
    }

    public User LogIn(String name, String password) throws UserNotFoundException, IncorrectPasswordException {
        User chillGuy = userRepo.GetUserByName(name);

        if (chillGuy == null) {
            throw new UserNotFoundException("User not found");
        }

        if (!chillGuy.IsPasswordMatch(password)) {
            throw new IncorrectPasswordException("Incorrect password");
        }

        return chillGuy;
    }
}
