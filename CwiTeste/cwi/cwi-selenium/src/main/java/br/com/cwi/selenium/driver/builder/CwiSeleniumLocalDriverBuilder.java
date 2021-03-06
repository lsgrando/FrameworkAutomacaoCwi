package br.com.cwi.selenium.driver.builder;

import br.com.cwi.selenium.driver.CwiSeleniumDriverLoader;
import br.com.cwi.selenium.driver.CwiSeleniumFirefoxDriver;
import br.com.cwi.selenium.driver.CwiSeleniumGoogleChromeDriver;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiSeleniumLocalDriverBuilder implements ICwiSeleniumDriverBuilder {

	private String navegador;
	
	public CwiSeleniumLocalDriverBuilder(String navegador) {
		
		this.navegador = navegador;
	}
	
	public CwiSeleniumDriverLoader build() {
		
		if ( navegador.equals( "chrome" ) ) {
            return new CwiSeleniumGoogleChromeDriver();
        } else if ( navegador.equals( "firefox" ) ) {
            return new CwiSeleniumFirefoxDriver();
        } else {
            throw new IllegalArgumentException( "Não foi possivel localizar o navegador: " + navegador );
        }
	}
}
