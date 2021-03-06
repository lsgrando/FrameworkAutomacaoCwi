package br.com.cwi.po;

import org.openqa.selenium.By;
import br.com.cwi.selenium.pageobject.AbstractCwiPageObject;
import br.com.cwi.selenium.utils.PropertiesUtil;

public class TesteGetNetPageObject extends AbstractCwiPageObject{
	
	private static final By btnPesquisar = By.id("search-trigger");
	private static final By btnProcurar = By.xpath("//div[@class='c-search-box-wrapper']//button[@class='o-btn o-btn--cor-roxo-borda c-search-box__button']");
	private static final By dsPesquisaGlobal = By.id("global-search-input");	
	
	public void acessarPagina() {
		
		get(PropertiesUtil.get("cwi.automacao.url"));		
				
	}
	
	public void clicarBotaoPesquisa() {
		
		findElement(btnPesquisar).click();
	}
	
	public void preecherCampoPesquisa(String dado) {
		
		findElement(dsPesquisaGlobal).sendKeys(dado);
	}
	
   public void clicarBotaoProcurar() {
		
		findElement(btnProcurar).click();
	}
   
   public void clicarPaginaResultadoBusca(String numeroPagina) {
	   
	   findElement(By.xpath("//div[@class='o-pagination']/a[text()="+ numeroPagina +"]")).click();
   }
	
   public void selecionarResultadoPesquisa(String resultadoPesquisa) {
	   
	   findElement(By.xpath("//div/section/a/h3[@class='c-search-page__result-title' and text()='"+ resultadoPesquisa +"']")).click();
	   
   }

}
