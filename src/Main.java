import repositoryy.UserRepository;
import ui.LoginFrame;
import util.DBConnection;

import javax.swing.SwingUtilities;

/**
 * Entry point of the authentication system.
 */
public class Main {

    public static void main(String[] args) {

        // Initialize database connection
        DBConnection.connect();

        // Ensure the users table exists
        UserRepository repository = new UserRepository();
        repository.createTable();

        // Launch the login interface
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}