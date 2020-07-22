package lq_autotest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import lq_autotest.common.User;

/**
 * 
 * Заглавная страница Mail.ru
 *
 */
public class StartPage extends BasePage {
	
	@FindBy(id="mailbox:login")
	protected WebElement login;
	
	@FindBy(id="mailbox:domain")
	protected WebElement domain;
	
	@FindBy(id="mailbox:submit")
	protected WebElement subminButton;

	public StartPage(WebDriver driver) {
		super(driver);
	}
	
	public MailBox LogIn (User user)  {
		
		wait(login).sendKeys(user.name);
		new Select(domain).selectByVisibleText(user.domain);
		subminButton.click();

		wait(By.id("mailbox:password")).sendKeys(user.password);
		wait(By.id("mailbox:submit")).click();
		
		return new MailBox(driver);
	}
}
