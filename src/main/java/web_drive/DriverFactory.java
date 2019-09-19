package web_drive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\web-drive\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\web-drive\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://google.com.br");
	}
}