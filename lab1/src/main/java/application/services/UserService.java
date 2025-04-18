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

    /**
     * Registers a new user in the system with the given name and password.
     * The registration process will fail if a user with the same name already exists.
     *
     * @param name     the name of the user to register
     * @param password the password of the user to register
     * @throws ATMExceptionApplication  if the registration fails for any reason
     * @throws NoSuchAlgorithmException if the algorithm used to hash the password is not available
     * @throws ATMExceptionDomainModel  if the registration fails due to a domain model exception
     */
    public void registration(String name, String password) throws ATMExceptionApplication, NoSuchAlgorithmException, ATMExceptionDomainModel {
        if (userRepo.getUserByName(name) != null) {
            throw new UserAlreadyExistsException("User with this name already exists");
        }

        User coolUser = new User(name, password);
        userRepo.addUser(coolUser);
    }

    /**
     * Logs in the user with the given name and password. If the user is not found in the database or the password is incorrect, throws an exception.
     *
     * @param name     the name of the user
     * @param password the password of the user
     * @return the logged-in user
     * @throws ATMExceptionApplication  if the user is not found or the password is incorrect
     * @throws NoSuchAlgorithmException if the hashing algorithm is not found
     */
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
