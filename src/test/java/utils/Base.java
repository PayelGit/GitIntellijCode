package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Properties prop;
    public WebDriver WebDriverManager() throws IOException {

        if(driver == null) {


        }
        return driver;
    }
    public Base()
    {
        try
        {

            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
            prop = new Properties();
            prop.load(fis);

        }
        catch (IOException e) {
            e.getMessage();
        }
    }

    public static void initialization()
    {
        String browserName = System.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//target//chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//target//chromedriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(GenericUtils.pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(GenericUtils.implicitWait, TimeUnit.SECONDS);
        driver.get(System.getProperty("url"));
    }

}
