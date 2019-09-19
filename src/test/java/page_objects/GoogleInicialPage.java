package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleInicialPage
{
	private WebDriver browser 	= new ChromeDriver();
	private WebDriverWait wait 	= new WebDriverWait(browser, 9999);
	
	private String url			= "https://www.google.com.br/";
	private By inputPesrquisar	= By.xpath("//input[@name='q']");
	private By btnPesquisar		= By.xpath("(//input[@name='btnK'])[2]");
	private By txtResultado		= By.id("resultStats");
	
	
	
	public void abrirPagina()
	{
		browser.get(url);
	}

	public void preencherFormPesquisa(String pesquisa)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputPesrquisar));
		browser.findElement(By.xpath("//input[@name='q']")).sendKeys(pesquisa);
	}

	public void pesquisar()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnPesquisar));
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
