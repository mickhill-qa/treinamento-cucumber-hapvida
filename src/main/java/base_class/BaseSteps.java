package base_class;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import support.BrowserFactory;

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
            byte[] screenshot = ((TakesScreenshot) BaseSteps.browser).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            scenario.write("URL ScreenShot: " + BaseSteps.browser.getCurrentUrl());
        } catch (WebDriverException wde) {
            scenario.write("Embed ScreenShot " + wde.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }
}
