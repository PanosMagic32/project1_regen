package org.regeneration.team4.project1.UI;

import org.regeneration.team4.project1.App.CustomWrapException;
import org.regeneration.team4.project1.App.InsuranceAppLogger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Printer {
    private final static Logger logger = Logger.getLogger(InsuranceAppLogger.class.getName());
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
        } catch (IOException exc) {
            logger.log(Level.SEVERE, "Error message for Team4: Couldn't printData() into file 'output.csv'!", exc);
            new CustomWrapException();
        }
    }
}