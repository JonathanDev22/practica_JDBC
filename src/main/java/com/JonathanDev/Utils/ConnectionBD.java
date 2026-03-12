package com.JonathanDev.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionBD {
    // Load database connection parameters from config.properties file
    private static String URL = "";
    private static String USER = "";
    private static String PASSWORD = "";
    private static Connection connection;
    private static final Logger logger = Logger.getLogger(ConnectionBD.class.getName());

    static {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
            URL = props.getProperty("DB_URL");
            USER = props.getProperty("DB_USER");
            PASSWORD = props.getProperty("DB_PASSWORD");
        } catch (IOException e) {
            logger.warning("Could not load config.properties, using default values. Reason: " + e.getMessage());
        }
    }

    /**
     * Method to obtain a database connection
     *
     * @return Connection object representing the database connection
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            logger.info("Database connection established successfully.");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

}
