import java.sql.*;

public class DButils {


    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/regen_ins?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "root";
    private static Connection connection;


    public Connection connect() throws Exception {
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null) connection.close();
    }


    //    select exp_date from vehicle where plate=usersPlate
    //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    //Date date = new Date();
    //String today = dateFormat.format(date));

    public static void searchByPlate(String usersPlate) throws Exception {

        String query = "SELECT cc, manufactured_year, co2emissions, exp_date FROM vehicle v join insurance i ON v.vehicle_id=i.vehicle_id WHERE v.plate=?";

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
        }

    }


    public DButils() {
    }

}
