package lq_autotest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * Форма создания нового письма
 *
 */
public class NewLetter extends BasePage {
	
	@FindBy(css="[data-type=to] label")
	protected WebElement to;
	
	@FindBy(name = "Subject")
	protected WebElement subject;
	
	@FindBy(css = ".cke_editable")
	protected WebElement body;
	
	@FindBy(css = ".compose-app__buttons [title=Отправить]")
	protected WebElement sendButton;

	public NewLetter(WebDriver driver){
		super(driver);
	}
	
	public void SetTo(String text) {
		wait(to).sendKeys(text);
	}
	
	public void SetSubject(String text) {
		wait(subject).sendKeys(text);
	}
	
	public void SetBody(String text) {
		wait(body).sendKeys(text);
	}
	
	public void Send() {
		wait(sendButton).click();
	}

}
