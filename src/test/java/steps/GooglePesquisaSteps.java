package steps;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.GoogleInicialPage;

public class GooglePesquisaSteps extends BaseSteps
{
    GoogleInicialPage paginaInicial;

	
	
	/**
     * Paginas necessaria aos passos
     **/
    public GooglePesquisaSteps()
    {
    	paginaInicial = new GoogleInicialPage(browser);
    }

	
	
	/**
	 * Hooks
	 **/
	@Before
	public void Init()
	{
	}

	@After
	public void Finish()
	{
		browser.quit();
	}

	
	
	 /**
     * Contexto
     **/
    @Dado("^que eu esteja na pagina inicial do google$")
	public void queEuEstejaNaPaginaInicialDoGoogle() 
	{
		paginaInicial.abrirPagina();
		paginaInicial.conferirSeEstouNaPaginaInicial();
	}

	
	
	/**
	 * pesquisaSuccess
	 **/
	@Quando("^eu pesquisar por um assunto$")
	public void euPesquisarPorUmAssunto() 
	{
		paginaInicial.preencherFormPesquisa("Teste Automatizado");
		paginaInicial.pesquisar();
	}
	
	@Entao("^me retorna os resultados indexados$")
	public void meRetornaOsResultadosIndexados() 
	{
		String txtAssertPage = paginaInicial.verResultadoPesquisa();
		Assert.assertEquals("Aproximadamente", txtAssertPage);
	}

	
	
	/**
	 * pesquisaUndefined
	 **/
	@Quando("^eu pesquisar sem preencher o assunto$")
	public void euPesquisarSemPreencherOAssunto()
	{
		paginaInicial.pesquisar();
	}
	
	@Entao("^continuarei na mesma pagian aguardando um assunto$")
	public void continuareiNaMesmaPagianAguardandoUmAssunto()
	{
		paginaInicial.conferirSeEstouNaPaginaInicial();
	}
}
