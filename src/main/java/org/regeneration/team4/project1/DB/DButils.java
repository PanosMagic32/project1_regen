package org.regeneration.team4.project1.DB;

import org.regeneration.team4.project1.App.PropertiesReader;
import org.regeneration.team4.project1.App.Team4Exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButils {

    static Connection connect() {
        Properties prop = PropertiesReader.getProps();

        String dbDriver = prop.getProperty("DB_DRIVER");
        String dbConnection = prop.getProperty("DB_CONNECTION");
        String dbUser = prop.getProperty("DB_USER");

        String dbPassword = System.getenv("DB_PASSWORD");

        try {
            Class.forName(dbDriver);
            return DriverManager.getConnection(dbConnection, dbUser, dbPassword);
        } catch (Exception e) {
            new Team4Exception(e);
        }
        return null;
    }

    static void terminate(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                new Team4Exception(e);
            }
        }
    }
}