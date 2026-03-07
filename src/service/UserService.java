package service;

import repositoryy.UserRepository;

/**
 * UserService handles the business logic related to user operations.
 *
 * It acts as a bridge between the UI layer and the repository layer.
 */
public class UserService {

    private UserRepository repository;

    /**
     * Constructor initializes the repository.
     */
    public UserService() {
        repository = new UserRepository();
    }

    /**
     * Registers a new user.
     *
     * @param username user name
     * @param password user password
     * @return true if registration succeeded
     */
    public boolean register(String username, String password) {

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        return repository.saveUser(username, password);
    }

    /**
     * Validates login credentials.
     *
     * @param username username entered
     * @param password password entered
     * @return true if login is valid
     */
    public boolean login(String username, String password) {

        return repository.validateUser(username, password);
    }
}