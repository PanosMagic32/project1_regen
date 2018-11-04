package org.regeneration.team4.project1.DB;

import org.regeneration.team4.project1.App.CustomWrapException;
import org.regeneration.team4.project1.App.InsuranceAppLogger;
import org.regeneration.team4.project1.App.PropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DButils {

    private static final Logger logger = Logger.getLogger(InsuranceAppLogger.class.getName());
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
            Class.forName(dbDriver);//used only for versions older than java 4
            connection = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
        } catch (Exception exc) {
            logger.log(Level.SEVERE, "Error message for Team4: Couldn't connect to database!", exc);
            new CustomWrapException();
        }
    }

    //disconnect connection to db
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException exc) {
                logger.log(Level.SEVERE, "Error message for Team4: Couldn't disconnect from database!", exc);
                new CustomWrapException();
            }
        }
    }
}