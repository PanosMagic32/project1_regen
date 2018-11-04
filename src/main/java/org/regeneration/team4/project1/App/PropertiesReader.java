package org.regeneration.team4.project1.App;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesReader {

    private final static Logger logger = Logger.getLogger(InsuranceAppLogger.class.getName());

    //reads the properties file that contains db connection info
    public static Properties getProps() {
        Properties prop = new Properties();

        // load a properties file
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
        } catch (IOException exc) {
            logger.log(Level.SEVERE, "Error message for Team4: Couldn't read properties file ('config.properties')!", exc);
            new CustomWrapException();
        }
        return prop;
    }
}
