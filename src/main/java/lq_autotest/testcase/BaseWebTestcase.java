package lq_autotest.testcase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import lq_autotest.common.AuthBy;
import lq_autotest.common.User;
import lq_autotest.page.MailBox;
import lq_autotest.page.StartPage;

public abstract class BaseWebTestcase {
	private WebDriver driver;
	private User user;
	public MailBox mailBox;
	
	public WebDriver getDriver() {
		return driver;
	}
	public User getUser() {
		return user;
	}

	@BeforeEach
	public void beforeEach(TestInfo testInfo) {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		//авторизация при указанном в аннотации пользователе
		if (testInfo.getTestMethod().get().isAnnotationPresent(AuthBy.class)){
			mailBox = Auth(testInfo.getTestMethod().get().getAnnotation(AuthBy.class).value());
		}
	}
	
	@AfterEach
	public void afterEach(TestInfo testInfo) {
		driver.close();
	}
	
	public MailBox Auth(User user)  {
		this.user = user;
		driver.get("https://mail.ru/");
		StartPage startPage = new StartPage(driver);
		return startPage.LogIn(user);
	}
}
