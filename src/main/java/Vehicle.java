public class Vehicle {

    private String plate;
    private int cc;
    private int manufactured_year;
    private String co2emissions;
    private int vehicle_id;
    private int owner_id;

    public Vehicle(String plate, int cc, int manufactured_year, String co2emissions, int vehicle_id, int owner_id) {
        this.plate = plate;
        this.cc = cc;
        this.manufactured_year = manufactured_year;
        this.co2emissions = co2emissions;
        this.vehicle_id = vehicle_id;
        this.owner_id = owner_id;
    }

    public String getPlate() {
        return plate;
    }

    public int getCc() {
        return cc;
    }

    public int getManufactured_year() {
        return manufactured_year;
    }

    public String getCo2emissions() {
        return co2emissions;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public int getOwner_id() {
        return owner_id;
    }
}
