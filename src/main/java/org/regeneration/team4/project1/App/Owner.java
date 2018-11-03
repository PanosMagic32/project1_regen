package org.regeneration.team4.project1.App;

import java.util.ArrayList;

public class Owner {

    private String fname;
    private String lname;
    private int oid;
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ;

    public Owner(String fname, String lname, int oid) {
        this.fname = fname;
        this.lname = lname;
        this.oid = oid;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getOid() {
        return oid;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addNewVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", vehicles are= '" + vehicles + '\'' +
                '}';
    }
}
