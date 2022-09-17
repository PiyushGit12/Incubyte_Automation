package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	public WebDriver driver;
	WebDriverWait wait;

	protected Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);

	}

	public abstract void getURL(String URL);
	
	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract WebElement getElement(By locator);

	public abstract List<WebElement> getListElement(By locator);

	public abstract void waitForElementPresent(By locator);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {

		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
