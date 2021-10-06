package page_objects;

import base_class.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PesquisaPage extends BasePage
{
    private String url			= "https://www.google.com.br/";
    private By inputPesrquisar	= By.xpath("//input[@name='q']");
    private By optionsPesrquisa = By.cssSelector("ul[role='listbox'] > li:nth-child(1)");
    private By btnPesquisar		= By.xpath("(//input[@name='btnK'])[2]");

    public PesquisaPage(WebDriver _browser)
    {
        super(_browser);
    }

    public void abrirPagina()
    {
        browser.get(url);
    }

    public void preencherFormPesquisa(String pesquisa)
    {
        waitElementVisible(inputPesrquisar, 5);
        browser.findElement(inputPesrquisar).sendKeys(pesquisa);
        waitElementVisible(optionsPesrquisa, 5);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void pesquisar()
    {
        browser.findElement(btnPesquisar).click();
    }

    public String getUrl()
    {
        return url;
    }
}
