public class Insurance {

    private String exp_date;
    private String init_date;
    private String cost;
    private int insurance_id;
    private int vehicle_id;
    private int owner_id;

    public Insurance(String exp_date, String init_date, String cost, int insurance_id, int vehicle_id, int owner_id) {
        this.exp_date = exp_date;
        this.init_date = init_date;
        this.cost = cost;
        this.insurance_id = insurance_id;
        this.vehicle_id = vehicle_id;
        this.owner_id = owner_id;
    }

    public String getExp_date() {
        return exp_date;
    }

    public String getInit_date() {
        return init_date;
    }

    public String getCost() {
        return cost;
    }

    public int getInsurance_id() {
        return insurance_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public int getOwner_id() {
        return owner_id;
    }
}
