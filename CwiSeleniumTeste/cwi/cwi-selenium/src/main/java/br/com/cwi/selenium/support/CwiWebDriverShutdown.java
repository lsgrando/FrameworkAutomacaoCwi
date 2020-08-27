package br.com.cwi.selenium.support;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiWebDriverShutdown implements Runnable {

    public void run() {
        
    	close();
    }

    /**
     * Fecha o navegador.
     */
    private static void close() {

        CwiWebDriver.close();
    }
}
