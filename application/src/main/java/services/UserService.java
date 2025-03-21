package services;

import exceptions.*;
import repointerfaces.UserRepo;
import entities.User;

public class UserService {
    private final UserRepo userRepo;


    public UserService(UserRepo repo) {
        userRepo = repo;
    }

    public void registration(String name, String password) throws InvalidUserNameException, InvalidUserPasswordException, UserAlreadyExistsException {
        if (userRepo.getUserByName(name) != null) {
            throw new UserAlreadyExistsException("User with this name already exists");
        }

        User coolUser = new User(name, password);
        userRepo.addUser(coolUser);
    }

    public User logIn(String name, String password) throws UserNotFoundException, IncorrectPasswordException {
        User chillGuy = userRepo.getUserByName(name);

        if (chillGuy == null) {
            throw new UserNotFoundException("User not found");
        }

        if (!chillGuy.isPasswordMatch(password)) {
            throw new IncorrectPasswordException("Incorrect password");
        }

        return chillGuy;
    }
}
