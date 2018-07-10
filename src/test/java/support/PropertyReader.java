package support;


import java.io.*;
import java.util.Properties;

public class PropertyReader {

    private Properties properties = new Properties();

    public PropertyReader(String proptype) {
        loadProperties(proptype);
    }

    private void loadProperties(String proptype) {
        try {
            InputStream inputStream = new FileInputStream("src/test/resources/properties/" + proptype + ".properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }

}

