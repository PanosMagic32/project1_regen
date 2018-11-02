import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Team4Exception extends Exception {

    public Team4Exception(Throwable cause) {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("insurance.log")));
            cause.printStackTrace(pw);
            pw.flush();
            System.out.println("\nOops! There's a glitch in the Matrix! Agent Smith dispatched! Run for your lives!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
}