package lq_autotest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lq_autotest.common.Configs;

public abstract class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement wait(WebElement element) {
		return new WebDriverWait(driver, Configs.WaitsTimeout).until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement wait(By by) {
		return new WebDriverWait(driver, Configs.WaitsTimeout).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
