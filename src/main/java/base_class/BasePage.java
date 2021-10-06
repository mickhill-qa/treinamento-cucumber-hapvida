package base_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{
    protected WebDriver browser;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver _browser)
    {
        browser = _browser;
        actions = new Actions(browser);
    }

    public void waitElementVisible(By element, int seconds) {
        wait = new WebDriverWait(browser, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
