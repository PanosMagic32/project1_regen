import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DButils {

    private static Connection connection;

    public DButils() {
    }

    void connect() throws Exception {
        Properties prop = PropertiesReader.getProps();

        String DB_DRIVER = prop.getProperty("DB_DRIVER");
        String DB_CONNECTION = prop.getProperty("DB_CONNECTION");
        String DB_USER = prop.getProperty("DB_USER");
        String DB_PASSWORD = prop.getProperty("DB_PASSWORD");

        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    }

    public void disconnect() throws SQLException {
        if (connection != null) connection.close();
    }

    ArrayList<Vehicle> getDBVehicles() throws Exception {

        String query = "SELECT * FROM vehicle";
        ArrayList<Vehicle> vList = new ArrayList<>();

        ResultSet rs = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            rs = preparedStatement.executeQuery(query);

            //iterate through results
            while (rs.next()) {
                int vid = rs.getInt("vid");
                String plate = rs.getString("plate");
                String ins_exp_date = rs.getString("ins_exp_date");
                int oid = rs.getInt("oid");
                Vehicle vehicle = new Vehicle(plate, ins_exp_date, vid, oid);
                vList.add(vehicle);
            }
            return vList;
        }
        finally {
            rs.close();
        }
    }

    public ArrayList<Owner> getDBOwners() throws SQLException {
        String query = "SELECT * FROM owner";
        ArrayList<Owner> oList = new ArrayList<>();

        ResultSet rs = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            rs = preparedStatement.executeQuery(query);

            //iterate through results
            while (rs.next()) {
                int oid = rs.getInt("oid");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                Owner owner = new Owner(fname, lname, oid);
                oList.add(owner);
            }
            return oList;
        }
        finally {
            rs.close();
        }
    }
}
