package JPetStore.JPetStoreAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JPetStoreLoginPage {

	WebDriver driver = null;
	By userName = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By login = By.xpath("//input[@name='signon']");
	/*
	 * By signup = By.xpath(""); 
	 * By home = By.xpath("");
	 */
	
	public JPetStoreLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement userName() {
		return driver.findElement(userName);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement login() {
		return driver.findElement(login);
	}
	
	/*
	 * public WebElement signup() { return driver.findElement(signup); }
	 * 
	 * public WebElement home() { return driver.findElement(home); }
	 */
	
}
