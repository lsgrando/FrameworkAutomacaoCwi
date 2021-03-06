package br.com.cwi.selenium.desiredcapabilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiSeleniumRemoteDesiredCapabilities implements CwiSeleniumDesiredCapabilities {

	private String browser;
	
	public CwiSeleniumRemoteDesiredCapabilities (String browser ) {
		
		this.browser = browser;
	}
	
	public DesiredCapabilities load() {
		
		ChromeOptions options=null;
    	
    	if (browser.equals("chrome")){
        	
        	 options = new ChromeOptions();
             options.addArguments("--disable-infobars");
             // Options Chrome -> Iniciar em modo anonimo
             options.addArguments("--incognito");
             // Options Chrome -> Iniciar em maximizado
             options.addArguments("start-maximized");
        }
    	
    	DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName( browser );
        if (options != null){
        	dc.setCapability(ChromeOptions.CAPABILITY, options);
        } 
        
        return dc;
	}
}
