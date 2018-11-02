import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBtableGetter {
    private ArrayList<Owner> oList;
    private ArrayList<Vehicle> vList;

    public ArrayList<Owner> getOwnersIncludedVehicles() {

        try {
            oList = getOwnersTable();
            vList = getVehiclesTable();
        } catch (Exception e) {
            new Team4Exception(e);
        }

        for (Owner o : oList) {
            for (Vehicle v : vList) {
                if (o.getOid() == v.getOid()) {
                    o.addNewVehicle(v);
                }
            }
        }
        return oList;

    }


    private ArrayList<Vehicle> getVehiclesTable() {

        Connection connection = DButils.connect();

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
            new Team4Exception(e);
        } finally {
            try {
                DButils.terminate(connection);
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                new Team4Exception(e);
            }
        }
        return vList;
    }

    private ArrayList<Owner> getOwnersTable() {

        Connection connection = DButils.connect();


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
            new Team4Exception(e);
        } finally {
            try {
                DButils.terminate(connection);
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                new Team4Exception(e);
            }
        }
        return oList;
    }
}