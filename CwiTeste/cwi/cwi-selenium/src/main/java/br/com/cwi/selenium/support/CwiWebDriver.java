package br.com.cwi.selenium.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cwi.selenium.driver.CwiSeleniumDriverLoader;
import br.com.cwi.selenium.driver.builder.CwiSeleniumDriverBuilder;
import br.com.cwi.selenium.utils.PropertiesUtil;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiWebDriver {

    private static final int DEFAULT_SLEEP_TIMEOUT = 30;

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getDriver() {

        if ( driver == null ) {

            createWebDriver();
        }

        return driver;
    }

    public static void close() {

        if ( driver != null ) {

            driver.quit();

            driver = null;
        }
    }
    
    public static WebDriverWait getWait() {
        return wait;
    }

    private static void createWebDriver() {

        try {

            driver = getDriverLoader().load();
            wait = new WebDriverWait( driver, DEFAULT_SLEEP_TIMEOUT );

        } finally {

        	Runtime.getRuntime().addShutdownHook(new Thread(new CwiWebDriverShutdown()));
        }
    }
    
    private static CwiSeleniumDriverLoader getDriverLoader() {

    	return new CwiSeleniumDriverBuilder()
                        .navegador( getNavegador() )
                        .host( getHost() )                        
                        .build();
    }
    
    /**
     * Busca do arquivo profile.properties qual navegador será usado na execução
     * @return o navegador setado
     */
    private static String getNavegador() {

        try {

            return PropertiesUtil.get( "cwi.selenium.navegador" );

        } catch ( Exception e ) {

            throw new IllegalArgumentException( "Nenhum Navegador Definido" );

        }
    }
    
    /**
     * Busca do arquivo profile.properties qual host será usado na execução (se for executado de forma remota)
     * @return o host setado se existir
     */
    private static String getHost() {

    	try {

            return PropertiesUtil.get( "cwi.selenium.host" );

        } catch ( Exception e ) {

        	System.out.println("Não foi definido Host para execução remota, execução ocorrerá localmente.\n" );       	
            return null;

        }        
    }
    
    public static Actions getActions() {

        return new Actions( driver );
    }
}

