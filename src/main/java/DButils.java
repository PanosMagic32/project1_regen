import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DButils {


    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/regen_ins?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "password";
    private static Connection connection;


    public Connection connect() throws Exception {
        Class.forName(DB_DRIVER);
        return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    }

    public void disconnect() throws SQLException {
        if (connection != null) connection.close();
    }


    //    select exp_date from vehicle where plate=usersPlate
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
	String today = dateFormat.format(date));

    public static void readOwner() throws Exception {

        String query = "SELECT * FROM owner";
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            rs = preparedStatement.executeQuery(query);

            //iterate through results
            while (rs.next()) {
                int oid = rs.getInt("owner_id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String tel = rs.getString("tel");
                String mail = rs.getString("mail");
                String addr = rs.getString("address");
                String adtn = rs.getString("adt_number");

                System.out.format("%s, %s, %s, %s, %s, %s, %s\n", oid, fname, lname, tel, mail, addr, adtn);
            }
        }

    }


    public DButils() {
    }

}
