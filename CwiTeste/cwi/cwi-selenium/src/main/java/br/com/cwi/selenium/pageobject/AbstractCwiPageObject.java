package br.com.cwi.selenium.pageobject;

import java.util.NoSuchElementException;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.cwi.selenium.components.CwiSeleniumModal;
import br.com.cwi.selenium.support.CwiWebDriver;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class AbstractCwiPageObject {
	
	public static final int timeout = 1000;
	
	protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    
    public AbstractCwiPageObject() {
    	
    	driver = CwiWebDriver.getDriver();
    	wait = CwiWebDriver.getWait();
    }
    
    /**
     * Abre a url e aguarda a pagina carregar.
     */
    public void get( String url ) {

        driver.navigate().to( url );
        wait.until( ExpectedConditions.presenceOfElementLocated(By.id("chaordic-remote-collect")));

    }    
    
    public WebElement findElement( By by ) {

        try {
            Thread.sleep( timeout );
        } catch ( InterruptedException e ) {
            throw new IllegalStateException( "falha ao executar o findElement: " + by );
        }
        if ( oElementoEstaPresente(this.driver, by) == true) {
        	WebElement webElement = driver.findElement( by );
            return webElement;
        }
        System.out.print( "Elemento Não Encontrado. Verificar se o elemento está presente na página");
        return null;
    }
    
    public WebElement waitPresenceOfElementLocated( By by ) {
    	
        return wait.until( ExpectedConditions.presenceOfElementLocated( by ) );        
    }
    
    private boolean oElementoEstaPresente( WebDriver driver, By by) {
        try {            
        	driver.findElement( by );
            return true;
        } catch ( NoSuchElementException e ) {
            return false;
        }
    }
    
    public void verificarTituloModal(String titulo) {
    	
    	CwiSeleniumModal modal = new CwiSeleniumModal();
    	String valorAtual;
    	valorAtual = modal.getTitleModal();
    	Assert.assertEquals( titulo, valorAtual );
    }
    
    public void verificarMensagemModal(String mensagem) {
    	
    	CwiSeleniumModal modal = new CwiSeleniumModal();
    	String valorAtual;
    	valorAtual = modal.getMessageModal();
    	Assert.assertEquals( mensagem, valorAtual );
    }
    
    @SuppressWarnings("deprecation")
	public void verificarContemMensagemModal (String mensagem) {
    	
    	CwiSeleniumModal modal = new CwiSeleniumModal();
    	String valorAtual = modal.getMessageModal();
    	Assert.assertThat(valorAtual, StringContains.containsString(mensagem));		    	
    }
    
    

}
