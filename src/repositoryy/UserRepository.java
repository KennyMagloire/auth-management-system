package repositoryy;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * UserRepository handles all database operations related to users.
 *
 * This class communicates directly with the SQLite database and
 * performs SQL queries such as creating tables, inserting users,
 * and validating login credentials.
 */
public class UserRepository {


    public void createTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT UNIQUE NOT NULL,
                    password TEXT NOT NULL
                );
                """;

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Users table ready.");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    /**
     * Saves a new user in the database.
     *
     * @param username user's chosen username
     * @param password hashed password
     * @return true if user was saved successfully
     */
    public boolean saveUser(String username, String password) {

        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Error saving user: " + e.getMessage());
            return false;
        }
    }

    /**
     * Checks if a user exists with the provided credentials.
     *
     * @param username username entered during login
     * @param password hashed password
     * @return true if the user exists in the database
     */
    public boolean validateUser(String username, String password) {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // returns true if a record is found

        } catch (SQLException e) {

            System.out.println("Login validation error: " + e.getMessage());
            return false;
        }
    }
}