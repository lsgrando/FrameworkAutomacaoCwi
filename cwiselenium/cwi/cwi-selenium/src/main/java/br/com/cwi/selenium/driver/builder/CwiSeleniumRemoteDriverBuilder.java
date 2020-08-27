package br.com.cwi.selenium.driver.builder;

import br.com.cwi.selenium.desiredcapabilities.CwiSeleniumRemoteDesiredCapabilities;
import br.com.cwi.selenium.driver.CwiSeleniumDriverLoader;
import br.com.cwi.selenium.driver.CwiSeleniumRemoteDriver;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiSeleniumRemoteDriverBuilder implements ICwiSeleniumDriverBuilder {

	private String navegador;
	private String host;
	
	public CwiSeleniumRemoteDriverBuilder(String navegador, String host) {
		
		this.navegador = navegador;
		this.host = host;	
	}
	
	public CwiSeleniumDriverLoader build() {
		
		CwiSeleniumRemoteDesiredCapabilities dc = new CwiSeleniumRemoteDesiredCapabilities(navegador);
		
		return new CwiSeleniumRemoteDriver(host, dc);
	}
}
