package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class responsible for creating a connection
 * to the SQLite database used by the authentication system.
 *
 * The database file is stored in the "database" folder
 * at the root of the project.
 */
public class DBConnection {

    // SQLite database connection URL
    private static final String URL = "jdbc:sqlite:./database/users.db";

    /**
     * Establishes a connection to the SQLite database.
     *
     * If the database file does not exist, SQLite will
     * automatically create it.
     *
     * @return Connection object if successful, otherwise null
     */
    public static Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Database connection established.");

        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }

        return conn;
    }
}