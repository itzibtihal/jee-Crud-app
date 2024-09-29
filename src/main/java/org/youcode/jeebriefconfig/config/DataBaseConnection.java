package org.youcode.jeebriefconfig.config;

import org.youcode.jeebriefconfig.exceptions.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/btcuisine";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    private static DataBaseConnection instance;
    private Connection connection;

    public DataBaseConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Error connecting to the database", e);
        }
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DataBaseConnection.class) {
                if (instance == null) {
                    instance = new DataBaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
