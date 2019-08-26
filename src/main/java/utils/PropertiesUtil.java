package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private InputStream input;

    private Properties properties;

    public PropertiesUtil(String pathToPropertiesFile) {
        try {
            this.input = new FileInputStream(pathToPropertiesFile);
            properties = new Properties();
            properties.load(input);
        }
        catch (FileNotFoundException ex) {

        }
        catch (IOException ex2){

        }
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }

}
