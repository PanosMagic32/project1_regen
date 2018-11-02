import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DButils {

    static Connection connect() {
        Properties prop = PropertiesReader.getProps();

        String dbDriver = prop.getProperty("DB_DRIVER");
        String dbConnection = prop.getProperty("DB_CONNECTION");
        String dbUser = prop.getProperty("DB_USER");
        String dbPassword = prop.getProperty("DB_PASSWORD");

        try {
            Class.forName(dbDriver);
            return  DriverManager.getConnection(dbConnection, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static void terminate(Connection connection) throws SQLException {
        if (connection != null) connection.close();
    }
}