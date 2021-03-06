package br.com.cwi.selenium.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.cwi.selenium.desiredcapabilities.CwiSeleniumDesiredCapabilities;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiSeleniumRemoteDriver implements CwiSeleniumDriverLoader {
	
	private String host;
	private CwiSeleniumDesiredCapabilities dc;
	
	public CwiSeleniumRemoteDriver(String host, CwiSeleniumDesiredCapabilities dc ) {
		
		this.host = host;
		this.dc = dc;
	}
		
	public WebDriver load() {

        try {
            return new RemoteWebDriver( new URL( host ), dc.load() );            
        } catch ( MalformedURLException e ) {        	
            throw new IllegalArgumentException( "A url: " + host + "é inválida", e );
        }
    }
}
