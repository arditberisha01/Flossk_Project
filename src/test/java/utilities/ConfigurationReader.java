package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    public static Properties properties = new Properties();

    //executes before everything else > that is why we use static block
    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
