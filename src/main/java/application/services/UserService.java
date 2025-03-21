package application.services;

import application.exceptions.ATMExceptionApplication;
import application.exceptions.IncorrectPasswordException;
import application.exceptions.UserAlreadyExistsException;
import application.exceptions.UserNotFoundException;
import domainmodel.entities.User;
import domainmodel.exceptions.ATMExceptionDomainModel;
import domainmodel.repointerfaces.UserRepo;

import java.security.NoSuchAlgorithmException;

public class UserService {
    private final UserRepo userRepo;


    public UserService(UserRepo repo) {
        userRepo = repo;
    }

    public void registration(String name, String password) throws ATMExceptionApplication, NoSuchAlgorithmException, ATMExceptionDomainModel {
        if (userRepo.getUserByName(name) != null) {
            throw new UserAlreadyExistsException("User with this name already exists");
        }

        User coolUser = new User(name, password);
        userRepo.addUser(coolUser);
    }

    public User logIn(String name, String password) throws ATMExceptionApplication, NoSuchAlgorithmException {
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
