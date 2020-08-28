package br.com.cwi.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.cwi.selenium.utils.PropertiesUtil;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiSeleniumFirefoxDriver implements CwiSeleniumDriverLoader {
	
	public WebDriver load() {

        System.setProperty("webdriver.gecko.driver", PropertiesUtil.get("cwi.selenium.caminho.geckodriver"));

        WebDriver driver = new FirefoxDriver();
     
        return driver;
    }
}
