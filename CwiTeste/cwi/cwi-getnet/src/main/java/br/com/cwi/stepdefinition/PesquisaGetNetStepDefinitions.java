package br.com.cwi.stepdefinition;

import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.cwi.po.TesteGetNetPageObject;
import br.com.cwi.selenium.pageobject.AbstractCwiPageObject;
import br.com.cwi.selenium.support.CwiWebDriver;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisaGetNetStepDefinitions extends AbstractCwiPageObject {
	
	private TesteGetNetPageObject testeGetNet;

	@After
    public void afterScenario() {

        CwiWebDriver.getDriver().close();
    }
	
	public PesquisaGetNetStepDefinitions() {
		
		testeGetNet = new TesteGetNetPageObject();
	}
	
	@Dado("^que acessei a pagina\\.$")
	public void que_acessei_a_pagina() {
	    
		testeGetNet.acessarPagina();
	}
	
	@Quando("^clicar no botão de pesquisa\\.$")
	public void clicar_no_botão_de_pesquisa() {
	   
		testeGetNet.clicarBotaoPesquisa();
	}
	
	@Quando("^informar \"([^\"]*)\"\\.$")
	public void informar(String dado) {
	   
		testeGetNet.preecherCampoPesquisa(dado);
	}

	@Quando("^clicar no botão procurar\\.$")
	public void clicar_no_botão_procurar() {
		
		testeGetNet.clicarBotaoProcurar();	    
	}
	
	@Quando("^clicar na pagina \"([^\"]*)\" do resultado das buscas\\.$")
	public void clicar_na_pagina_do_resultado_das_buscas(String numeroPagina) {
	    
		testeGetNet.clicarPaginaResultadoBusca(numeroPagina);
	}
	
	@Quando("^clicar no resultado da busca \"([^\"]*)\"\\.$")
	public void clicar_no_resultado_da_busca(String resultadoPesquisa) {
	    
		testeGetNet.selecionarResultadoPesquisa(resultadoPesquisa);
	}

	@Quando("^verificar o título do modal \"([^\"]*)\"\\.$")
	public void verificar_o_título_do_modal(String titulo) {
	    
		verificarTituloModal(titulo);
	}

	@Então("^o modal deve conter a mensagem \"([^\"]*)\"\\.$")
	public void o_modal_deve_conter_a_mensagem(String mensagem) {
		
		verificarContemMensagemModal(mensagem);
	}

}
