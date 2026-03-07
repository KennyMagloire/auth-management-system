package ui;

import javax.swing.*;
import java.awt.*;
import service.UserService;
import ui.RegisterFrame;

/**
 * LoginFrame represents the main login window of the application.
 * It allows users to enter their username and password
 * and attempt authentication.
 */

public class LoginFrame extends JFrame {
    /**
     * Constructor that initializes the login window UI.
     */
    private UserService userService = new UserService();

    public LoginFrame() {


        setTitle("Auth Management System - Login");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel to organize UI components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));

        //Username input
        JLabel userLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        //Password input
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

         //Create buttons
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        // Open the registration window when register button is clicked
        registerButton.addActionListener(e -> {

            new RegisterFrame();

        });

        //Add components to panel
        panel.add(userLabel);
        panel.add(usernameField);

        panel.add(passLabel);
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);

        /**
         * LOGIN BUTTON ACTION
         *
         * When the user clicks the login button:
         * 1. Retrieve the username and password entered
         * 2. Send them to the service layer
         * 3. Display success or failure message
         */
        loginButton.addActionListener(e -> {

            // Retrieve the username and password entered by the user
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Validate input fields before checking the database
            if (username.isEmpty() || password.isEmpty()) {

                // Show warning if user did not enter required information
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter both username and password.",
                        "Input Error",
                        JOptionPane.WARNING_MESSAGE
                );

                return; // Stop execution if fields are empty
            }

            // Call the service layer to validate credentials
            boolean loginSuccessful = userService.login(username, password);

            // Display result to the user
            if (loginSuccessful) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login successful!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid username or password."
                );
            }

        });
        // Make window visible
        setVisible(true);
    }

}