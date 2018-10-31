public class Vehicle {

    private String plate;
    private String ins_exp_date;
    private int vehicle_id;
    private int owner_id;

    public Vehicle(String plate, String ins_exp_date, int vehicle_id, int owner_id) {
        this.plate = plate;
        this.ins_exp_date = ins_exp_date;
        this.vehicle_id = vehicle_id;
        this.owner_id = owner_id;
    }

    public String getPlate() {
        return plate;
    }

    public String getIns_exp_date() {
        return ins_exp_date;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    @Override
    public String toString() {
        return " " + plate.toUpperCase() + "     " + ins_exp_date+"\n";
    }
}
