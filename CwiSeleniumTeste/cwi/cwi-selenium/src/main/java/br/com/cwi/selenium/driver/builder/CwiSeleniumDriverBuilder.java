package br.com.cwi.selenium.driver.builder;

import br.com.cwi.selenium.driver.CwiSeleniumDriverLoader;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiSeleniumDriverBuilder implements ICwiSeleniumDriverBuilder {

	private String navegador;
	private String host;
	
	public CwiSeleniumDriverBuilder navegador( String navegador) {
		
		this.navegador = navegador;
				
		return this;		
	}
	
	public CwiSeleniumDriverBuilder host( String host) {
		
		this.host = host;
				
		return this;		
	}
	
	/**
	 * Verifica se possuí host informado se possuir executa com o remote senão executa local
	 */
	public CwiSeleniumDriverLoader build() {
		
		if ( host == null || host.trim().isEmpty()) {
			
			return new CwiSeleniumLocalDriverBuilder(navegador).build();
		}
		else
		{
			return new CwiSeleniumRemoteDriverBuilder(navegador, host).build();
		}
	
	}
}
