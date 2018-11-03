package org.regeneration.team4.project1.App;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    //reads the properties file that contains db connection info
    public static Properties getProps() {
        Properties prop = new Properties();

        // load a properties file
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
        } catch (IOException exc) {
            new CustomWrapException(exc);
        }
        return prop;
    }
}
