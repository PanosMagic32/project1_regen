package org.regeneration.team4.project1.App;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class InsuranceAppLogger {

    private final static Logger logger = Logger.getLogger(InsuranceAppLogger.class.getName());
    private static FileHandler fh = null;

    static void init() {
        try {
            fh = new FileHandler("insurance.log", false); // TODO: Change append to 'TRUE' before release!!
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        fh.setFormatter(new SimpleFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(fh);
    }
}
