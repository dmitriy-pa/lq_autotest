package lq_autotest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * Главная страница почтового ящика
 *
 */
public class MailBox extends BasePage {
	
	@FindBy(className = "compose-button")
	protected WebElement newLetterButton;

	public MailBox(WebDriver driver){
		super(driver);
	}
	
	public NewLetter NewLetter() {
		wait(newLetterButton).click();
		return new NewLetter(driver);
	}
}
