package org.regeneration.team4.project1.App;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static Properties getProps() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            // load a properties file
            prop.load(input);
        } catch (IOException e) {
            new Team4Exception(e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    new Team4Exception(e);
                }
            }
        }
        return prop;
    }
}