package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleInicialPage
{
	private WebDriver browser;
	private WebDriverWait wait;
	
	private String url			= "https://www.google.com.br/";
	private By inputPesrquisar	= By.xpath("//input[@name='q']");
	private By optionsPesrquisa = By.cssSelector("#tsf > div:nth-child(2) > div > div > div > ul > li");
	private By btnPesquisar		= By.xpath("(//input[@name='btnK'])[2]");
	private By txtResultado		= By.id("result-stats");
	
	
	
	public GoogleInicialPage()
	{
//		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\web-drive\\geckodriver.exe");
//		WebDriver browser = new FirefoxDriver();
		
//		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\web-drive\\chromedriver.exe");
		browser = new ChromeDriver();
		
		wait 	= new WebDriverWait(browser, 9999);
	}

	public void abrirPagina()
	{
		browser.get(url);
	}

	public void preencherFormPesquisa(String pesquisa)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputPesrquisar));
		browser.findElement(inputPesrquisar).sendKeys(pesquisa);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(optionsPesrquisa));
		browser.findElement(inputPesrquisar).sendKeys(Keys.ESCAPE);
	}

	public void pesquisar()
	{
		browser.findElement(btnPesquisar).click();
	}

	public String verResultadoPesquisa()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtResultado));
		return browser.findElement(txtResultado).getText().substring(0,15);
	}
	
	public Boolean conferirSeEstouNaPaginaInicial()
	{
		String paginaAtual = browser.getCurrentUrl();
		return url.equals(paginaAtual);
	}

	public void fecharPagina()
	{
		browser.quit();
	}
}
