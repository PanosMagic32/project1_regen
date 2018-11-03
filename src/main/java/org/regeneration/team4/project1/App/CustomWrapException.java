package org.regeneration.team4.project1.App;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomWrapException extends Exception {

    Logger logger = Logger.getLogger("Team4Log");
    FileHandler fh;

    public CustomWrapException(Throwable cause) {

        try {
            logger.setUseParentHandlers(false);

            fh = new FileHandler("insurance.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.log(Level.SEVERE, "Team4Logger", cause);
            System.out.println("\nOops! There's a glitch in the Matrix! Agent Smith dispatched! Run for your lives!");

            System.exit(-1);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}