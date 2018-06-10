package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(){
        //Search for the driver
        String driverDirectory = System.getProperty("user.dir")
                + "\\drivers\\chromedriver.exe";

        // Creates a instance of the driver
        System.setProperty("webdriver.chrome.driver", driverDirectory);

        // Set up the options for Chrome start maximized
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver browser = new ChromeDriver(options);

        // Define the implicit wait
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Browse to the start page
        browser.get("https://accounts.google.com/ServiceLogin/identifier?service=mail");

        return browser;
    }

    public static WebDriver createFirefox(){
        //Search for the driver
        String driverDirectory = System.getProperty("user.dir")
                + "\\drivers\\geckodriver.exe";

        // Creates a instance of the driver
        System.setProperty("webdriver.gecko.driver", driverDirectory);
        WebDriver browser = new FirefoxDriver();

        // Define the implicit wait
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Maximizando a janela do browser
        browser.manage().window().maximize();

        // Browse to the start page
        browser.get("https://accounts.google.com/ServiceLogin/identifier?service=mail");

        return browser;
    }

}
