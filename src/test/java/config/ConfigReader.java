package config;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadProperties(String env){

        try {

            FileInputStream file =
                    new FileInputStream("src/test/java/config/" + env + ".properties");
            properties = new Properties();
            properties.load(file);

        } catch (Exception e){

            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {

        String value = System.getProperty(key);

        if (value != null) {
            return value;
        }

        return properties.getProperty(key);
    }
}