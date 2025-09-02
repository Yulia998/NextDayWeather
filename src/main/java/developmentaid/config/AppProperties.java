package developmentaid.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
    public static String apiKey;

    static {
        apiKey = loadKey("apiKey");
    }

    public static String loadKey(String key) {
        Properties properties = new Properties();
        try (InputStream input = AppProperties.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.printf("%s cannot be got as application.properties was not found%n", key);
                return null;
            }
            properties.load(input);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.out.println("Error while loading data from application.properties. " + e);
            return null;
        }
    }
}
