import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DButils {

    private static Connection connection;



    public DButils() {
    }

    void connect() throws Exception {
        Properties prop = PropertiesReader.getProps();

        String dbDriver = prop.getProperty("DB_DRIVER");
        String dbConnection = prop.getProperty("DB_CONNECTION");
        String dbUser = prop.getProperty("DB_USER");
        String dbPassword = prop.getProperty("DB_PASSWORD");

        Class.forName(dbDriver);
        connection = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
    }

    public void disconnect() throws SQLException {
        if (connection != null) connection.close();
    }

    ArrayList<Vehicle> getDBVehicles() {

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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    ArrayList<Owner> getDBOwners() {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    void mergeOwnersVehicles(ArrayList<Owner> oList, ArrayList<Vehicle> vList){
        for(Owner o : oList){
            for(Vehicle v:vList){
                if(o.getOid()==v.getOid()){
                    o.addNewVehicle(v);
                }
            }
        }
    }
}
