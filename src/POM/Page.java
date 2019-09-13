package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	WebDriver driver;
	WebDriverWait wait;

	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15);
		}
	public abstract String getPageTitle();
	public abstract String getPageHeader();
	public abstract WebElement getElements(By locator);
	public abstract void waitForElemenstPresent(By locator);
	public abstract void waitForPageTitle(String title);
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageclass) {
		try {
			return pageclass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
