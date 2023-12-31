package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private Driver (){ }; //singleton design pattern > so the same driver can be used everywhere

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver == null){

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("Browser type is wrong");
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
