package org.regeneration.team4.project1.UI;

import org.regeneration.team4.project1.App.Team4Exception;

import java.io.BufferedWriter;
import java.io.IOException;

public class Printer {
    private BufferedWriter myOutput;

    public Printer(BufferedWriter myOutput) {
        this.myOutput = myOutput;
    }

    /**
     * The {@code printData} method prints the parameter {@code stringToPrint}
     * to a file named "output.txt" or to users console window.
     * <p>
     * The destination output depends from the users choice on the {@code org.regeneration.team4.project1.App.Main.printExportTypeMenu()} method.
     *
     * @param stringToPrint String to be written
     * @throws IOException If an I/O error occurs
     */
    public void printData(String stringToPrint) {
        try {
            this.myOutput.write(stringToPrint);
            this.myOutput.flush();
        } catch (IOException e) {
            new Team4Exception(e);
        }
    }
}