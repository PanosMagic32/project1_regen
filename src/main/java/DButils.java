import java.sql.*;
import java.util.ArrayList;

public class DButils {


    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/regen_ins?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "5288";
    private static Connection connection;


    public Connection connect() throws Exception {
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null) connection.close();
    }



    public  ArrayList<Vehicle> getDBVehicles() throws Exception {

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
            }return vList;
        }

    }

/*
    public void forcomingExpiries(int timeFrame) {

       String query = "SELECT i.exp_date,i.init_date,v.plate,v.cc,v.manufactured_year \n" +
                "FROM insurance i join vehicle v \n" +
                "ON v.vehicle_id=i.vehicle_id \n" +
                "WHERE i.exp_date<(select DATE_ADD(DATE_FORMAT(NOW(),'%Y%m%d'), INTERVAL 80 DAY)) \n" +
                "and i.exp_date>(select DATE_FORMAT(NOW(),'%Y%m%d'));\n";

        ResultSet rs = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, usersPlate);
            rs = preparedStatement.executeQuery();

            if (rs.last()) {
                int cc = rs.getInt("cc");
                String manufactured_year = rs.getString("manufactured_year");
                String co2emissions = rs.getString("co2emissions");
                String exp_date = rs.getString("exp_date");
                usersPlate=usersPlate.toUpperCase();

                System.out.format("\n\n\n\n\n\n\n---------------------------\n--- Vehicle's Status\n---------------------------\n");
                System.out.format("Vehicle's plate: %s\nEngine Capacity: %scc\nManufactured Year: %s\nCO₂ Emissions: %s\nExpire Date: %s\n",usersPlate, cc, manufactured_year, co2emissions, exp_date);
                System.out.println("---------------------------");
            }else{
                System.out.println("Plate not found, please try again!");
            }

    }*/


    public DButils() {
    }
}
