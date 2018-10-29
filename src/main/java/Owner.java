import java.util.ArrayList;

public class Owner {

    private String first_name;
    private String last_name;
    private String tel;
    private String mail;
    private String address;
    private String adt_number;
    private int owner_id;
    private ArrayList<Vehicle> vehicleList;

    public Owner(String first_name, String last_name, String tel, String mail, String address, String adt_number, int owner_id, ArrayList<Vehicle> vehicleList) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.tel = tel;
        this.mail = mail;
        this.address = address;
        this.adt_number = adt_number;
        this.owner_id = owner_id;
        this.vehicleList = vehicleList;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }

    public String getAdt_number() {
        return adt_number;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }
}
