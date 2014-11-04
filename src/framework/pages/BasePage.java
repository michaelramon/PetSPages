package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
	protected WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement findByID(String link) {
		return driver.findElement(By.id(link));
	}

	public WebElement findByXPath(String link) {
		return driver.findElement(By.xpath(link));
	}

	public WebElement findByCSSselector(String link) {
		return driver.findElement(By.cssSelector(link));
	}

	public WebElement findByLink(String link) {
		return driver.findElement(By.linkText(link));
	}

	public WebElement findByName(String link) {
		return driver.findElement(By.name(link));
	}

	public WebElement findByPartial(String link) {
		return driver.findElement(By.partialLinkText(link));
	}

}
