import java.util.ArrayList;

public class Owner {

    private String fname;
    private String lname;
    private int oid;
    private ArrayList<Vehicle> vList;

    public Owner(String fname, String lname, int oid) {
        this.fname = fname;
        this.lname = lname;
        this.oid = oid;
        this.vList= new ArrayList<Vehicle>();
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

    public ArrayList<Vehicle> getvList() {
        return vList;
    }

    public void addNewVList(ArrayList<Vehicle> vList) {
        this.vList = vList;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", vehicles are= '"+ vList +'\'' +
                '}';
    }
}
