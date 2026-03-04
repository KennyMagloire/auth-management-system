package ui;

import javax.swing.*;
import java.awt.*;

/**
 * LoginFrame represents the main login window of the application.
 * It allows users to enter their username and password
 * and attempt authentication.
 */

public class LoginFrame extends JFrame {
    /**
     * Constructor that initializes the login window UI.
     */


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

         //Action buttons
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        //Add components to panel
        panel.add(userLabel);
        panel.add(usernameField);

        panel.add(passLabel);
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);

        // Make window visible
        setVisible(true);
    }

}