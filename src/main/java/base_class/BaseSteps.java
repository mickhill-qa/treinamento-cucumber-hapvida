package base_class;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import support.BrowserFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseSteps
{
    public static WebDriver browser;
    public static Scenario scenario;

    public static void OpenBrowser() throws Throwable
    {
        if (browser != null) return;
        browser = BrowserFactory.getBrownser();
    }

    public static void CloseBrowser() throws Throwable
    {
        if (browser == null) return;
        browser.quit();
        browser = null;
        Thread.sleep(1500);
    }

    public static void screenShotNow()
    {
        try {
            String dataHora = (new SimpleDateFormat("yyyy-MM-dd_-_HH-mm-ss-SSS")).format(new Date());
            byte[] screenshot = ((TakesScreenshot) BaseSteps.browser).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", dataHora + ".png");
        } catch (WebDriverException wde) {
            scenario.log("Embed ScreenShot " + wde.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }
}
