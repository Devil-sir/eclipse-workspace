package JPetStore.JPetStoreAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JPetStoreAddToCart {
	
	WebDriver driver = null;
	By addToCart = By.xpath("//a[normalize-space()='Add to Cart']");
	By updateCart = By.xpath("//input[@name='updateCartQuantities']");
	By checkout = By.xpath("//a[normalize-space()='Proceed to Checkout']");
	By newOrder = By.xpath("//input[@name='newOrder']");
	By confirm = By.xpath("//a[normalize-space()='Confirm']");
	
	public JPetStoreAddToCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement AddtoCart() {
		return driver.findElement(addToCart);
	}
	
	public WebElement UpdateCart() {
		return driver.findElement(updateCart);
	}
	
	public WebElement Checkout() {
		return driver.findElement(checkout);
	}
	public WebElement NewOrder() {
		return driver.findElement(newOrder);
	}
	public WebElement Confirm() {
		return driver.findElement(confirm);
	}
	
}
