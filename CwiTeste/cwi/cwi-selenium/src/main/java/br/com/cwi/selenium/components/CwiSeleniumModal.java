package br.com.cwi.selenium.components;

import org.openqa.selenium.By;

import br.com.cwi.selenium.pageobject.AbstractCwiPageObject;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class CwiSeleniumModal extends AbstractCwiPageObject{
	
	private static final By modal = By.xpath("//div[@class='o-modal is-modal-open']");
	private static final By modalTitle = By.xpath("//div[@class='o-modal is-modal-open']//div[@class='o-modal__title']");
	private static final By modalMessage = By.xpath("//div[@class='o-modal is-modal-open']//div[@class='o-modal__text-content']");

	public By getModalTitleBy() {
		return modalTitle;	
	}
	
	public By getModalMessageBy() {
		return modalMessage;		
	}
	
	public String getTitleModal() {
        String mensagem;
        waitPresenceOfElementLocated(modalTitle);
        mensagem = findElement(modalTitle).getText();
        
        return mensagem;
    }
	
	public String getMessageModal() {
        String mensagem;
        waitPresenceOfElementLocated(modalMessage);
        mensagem = findElement(modalMessage).getText();

        return mensagem;
    }
	
}
