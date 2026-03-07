package ui;

import service.UserService;

import javax.swing.*;
import java.awt.*;

/**
 * RegisterFrame represents the registration window
 * where new users can create an account.
 */
public class RegisterFrame extends JFrame {

    // Service layer used to save the user
    private UserService userService = new UserService();

    public RegisterFrame() {

        setTitle("Create Account");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));

        // Username input
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        // Password input
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        // Confirm password input
        JLabel confirmLabel = new JLabel("Confirm Password:");
        JPasswordField confirmField = new JPasswordField();

        JButton createButton = new JButton("Create Account");

        panel.add(usernameLabel);
        panel.add(usernameField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(confirmLabel);
        panel.add(confirmField);

        panel.add(new JLabel(""));
        panel.add(createButton);

        add(panel);

        /**
         * When the user clicks "Create Account",
         * validate inputs and save the user.
         */
        createButton.addActionListener(e -> {

            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmField.getPassword());

            // Validate empty fields
            if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields.",
                        "Input Error",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // Check if passwords match
            if(!password.equals(confirmPassword)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Passwords do not match."
                );

                return;
            }

            // Attempt to save the user
            boolean registered = userService.register(username, password);

            if(registered) {

                JOptionPane.showMessageDialog(
                        this,
                        "Account created successfully!"
                );

                dispose(); // close register window

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Username already exists."
                );
            }

        });

        setVisible(true);
    }
}