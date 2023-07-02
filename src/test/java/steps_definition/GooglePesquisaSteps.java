package steps_definition;

import base_class.BaseSteps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import page_objects.PesquisaPage;
import page_objects.ResultadosPage;

public class GooglePesquisaSteps extends BaseSteps
{
    /**
     * Paginas necessaria
     **/
    PesquisaPage pageHome     = new PesquisaPage(BaseSteps.browser);
    ResultadosPage pageResult = new ResultadosPage(BaseSteps.browser);



    /**
     * Cenario: Pesquisa Valida
     * @pesquisaSuccess
     **/
    @Dado("^que eu esteja na pagina inicial do google$")
    public void que_eu_esteja_na_pagina_inicial_do_google()
    {
        pageHome.abrirPagina();
        String expectedPage = pageHome.getUrl();
        String currentPage = browser.getCurrentUrl();
        Assert.assertTrue( expectedPage.equals(currentPage) );
        BaseSteps.screenShotNow();
    }

    @Quando("^eu pesquisar por um assunto$")
    public void eu_pesquisar_por_um_assunto()
    {
        pageHome.preencherFormPesquisa("Teste Automatizado");
        BaseSteps.screenShotNow();
        pageHome.pesquisar();
    }

    @Entao("^me retorna os resultados indexados$")
    public void me_retorna_os_resultados_indexados()
    {
        String txtAssertPage = pageResult.verResultadoPesquisa();
        Assert.assertEquals("About", txtAssertPage);
        BaseSteps.screenShotNow();
    }



    /**
     * Cenario: Pesquisa Valida
     * @pesquisaSuccess
     **/
    @Quando("^eu pesquisar sem preencher o assunto$")
    public void eu_pesquisar_sem_preencher_o_assunto()
    {
        pageHome.pesquisar();
        BaseSteps.screenShotNow();
    }

    @Entao("^continuarei na mesma pagian aguardando um assunto$")
    public void continuarei_na_mesma_pagian_aguardando_um_assunto()
    {
        String expectedPage = pageHome.getUrl();
        String currentPage = browser.getCurrentUrl();
        Assert.assertTrue( expectedPage.equals(currentPage) );
    }
}
