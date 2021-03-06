package org.regeneration.team4.project1.DB;

import org.regeneration.team4.project1.App.CustomWrapException;
import org.regeneration.team4.project1.App.InsuranceAppLogger;
import org.regeneration.team4.project1.App.Owner;
import org.regeneration.team4.project1.App.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBtableGetter {
    private static final Logger logger = Logger.getLogger(InsuranceAppLogger.class.getName());
    private Connection connection;
    private ArrayList<Owner> oList;
    private ArrayList<Vehicle> vList;

    public DBtableGetter(DButils dButils) {
        this.connection = dButils.getConnection();
    }

    //merge vehicles per owner in owner list
    public ArrayList<Owner> getOwnersIncludedVehicles() {
        oList = getOwnersTable();
        vList = getVehiclesTable();
        for (Owner o : oList) {
            for (Vehicle v : vList) {
                if (o.getOid() == v.getOid()) {
                    o.addNewVehicle(v);
                }
            }
        }
        return oList;
    }

    //return vehicles from db
    private ArrayList<Vehicle> getVehiclesTable() {

        String query = "SELECT vid, plate, ins_exp_date, oid FROM vehicle";
        vList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery(query)) {

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
        } catch (SQLException exc) {
            logger.log(Level.SEVERE, "Error message for Team4: Couldn't retrieve table 'Vehicle' from database!", exc);
            new CustomWrapException();
        }
        return vList;
    }

    //return owners from db
    private ArrayList<Owner> getOwnersTable() {

        String query = "SELECT oid, fname, lname FROM owner";
        oList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery(query)) {

            //iterate through results
            while (rs.next()) {
                int oid = rs.getInt("oid");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                Owner owner = new Owner(fname, lname, oid);
                oList.add(owner);
            }
            return oList;
        } catch (SQLException exc) {
            logger.log(Level.SEVERE, "Error message for Team4: Couldn't retrieve table 'Owner' from database!", exc);
            new CustomWrapException();
        }
        return oList;
    }
}