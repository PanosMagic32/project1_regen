package org.regeneration.team4.project1.DB;

import org.regeneration.team4.project1.App.CustomWrapException;
import org.regeneration.team4.project1.App.PropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButils {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    //create connection to db
    public void connect() {
        Properties prop = PropertiesReader.getProps();

        String dbDriver = prop.getProperty("DB_DRIVER");
        String dbConnection = prop.getProperty("DB_CONNECTION");
        String dbUser = prop.getProperty("DB_USER");

        String dbPassword = System.getenv("DB_PASSWORD");

        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
        } catch (Exception exc) {
            new CustomWrapException(exc);
        }
    }

    //disconnect connection to db
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException exc) {
                new CustomWrapException(exc);
            }
        }
    }
}