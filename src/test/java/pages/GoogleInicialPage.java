package pages;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleInicialPage extends BasePage
{
	private String url			= "https://www.google.com.br/";
	private By inputPesrquisar	= By.xpath("//input[@name='q']");
	private By optionsPesrquisa = By.cssSelector("#tsf > div:nth-child(2) > div > div > div > ul > li");
	private By btnPesquisar		= By.xpath("(//input[@name='btnK'])[2]");
	private By txtResultado		= By.id("result-stats");
	
	
	public GoogleInicialPage(WebDriver _browser)
	{
		super(_browser);
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
		actions.sendKeys(Keys.ESCAPE).perform();
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
	
	public void conferirSeEstouNaPaginaInicial()
	{
		String paginaAtual = browser.getCurrentUrl();
		Assert.assertEquals(true, url.equals(paginaAtual));
	}
}
