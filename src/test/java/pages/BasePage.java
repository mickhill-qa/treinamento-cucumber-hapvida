package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
		wait = new WebDriverWait(browser, 5000);
	}
}
