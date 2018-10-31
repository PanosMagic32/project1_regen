import java.util.ArrayList;

public class Owner {

    private String fname;
    private String lname;
    private int oid;

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

    @Override
    public String toString() {
        return "Owner{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
