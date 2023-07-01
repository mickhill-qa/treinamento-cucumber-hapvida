package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserFactory
{
    public static enum Browser
    {
        CHROME,
        CHROME_HEADLESS,
        FIREFOX,
        FIREFOX_HEADLESS
    }

    public static WebDriver getBrownser()
    {
        return getBrownser(Browser.CHROME_HEADLESS); // Browser Default
    }

    public static WebDriver getBrownser(Browser browserUser)
    {
        WebDriver resultBrowser;
        // System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver",  "src\\test\\resources\\webdrivers\\geckodriver.exe");

        // Reduzindo Log do selenium
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        switch (browserUser)
        {
            case CHROME:
                resultBrowser = new ChromeDriver();
                resultBrowser.manage().window().maximize();
                break;
            case CHROME_HEADLESS:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-crash-reporter");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-in-process-stack-traces");
                options.addArguments("--disable-logging");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--log-level=3");
                options.addArguments("--output=/dev/null");
                resultBrowser = new ChromeDriver(options);
                break;
            case FIREFOX:
                resultBrowser = new FirefoxDriver();
                resultBrowser.manage().window().maximize();
                break;
            case FIREFOX_HEADLESS:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--window-size=1920,1080");
                resultBrowser = new FirefoxDriver(firefoxOptions);
                break;
            default:
                resultBrowser = null;
                new Exception("Browser Nao Suportado");
        }
        return resultBrowser;
    }
}
