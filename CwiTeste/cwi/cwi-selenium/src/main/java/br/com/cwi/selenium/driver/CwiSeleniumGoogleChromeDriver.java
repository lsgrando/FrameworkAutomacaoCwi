package br.com.cwi.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.com.cwi.selenium.utils.PropertiesUtil;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiSeleniumGoogleChromeDriver implements CwiSeleniumDriverLoader {
	
	
	public WebDriver load() {

        System.setProperty( "webdriver.chrome.driver", PropertiesUtil.get("cwi.selenium.caminho.chromedriver") );

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        // Options Chrome -> Iniciar em modo anonimo
        options.addArguments("--incognito");
        // Options Chrome -> Iniciar em maximizado
        options.addArguments("start-maximized");
        // Options Chrome -> Acessar endereçoes externos
        options.addArguments("--whitelisted-ips=");
        
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }
}
