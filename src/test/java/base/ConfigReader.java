package base;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static final String path = "config.properties";

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        Log.info("Read value from config.properties for " + key + " = " + properties.getProperty(key));
        return properties.getProperty(key);
    }

    static String browser = getProperty("browser");
    static String url = getProperty("baseurl");
    public static String userName = getProperty("userName");
    public static String passWord = getProperty("passWord");
    public static String keyWord = getProperty("keyWord");
    public static String pageNumber = getProperty("pageNumber");
}
