package JPetStore.JPetStoreAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JPetStoreFishCategory {
	
	WebDriver driver = null;
	By angleFish = By.xpath("//a[normalize-space()='FI-SW-01']");
	By lagre = By.xpath("//a[normalize-space()='EST-1']");
	By small = By.xpath("//a[normalize-space()='EST-2']");
	
	
	By tigerShark = By.xpath("//a[normalize-space()='FI-SW-02']");
	By toothless = By.xpath("//a[normalize-space()='EST-3']");

	
	By koi = By.xpath("//a[normalize-space()='FI-SW-03']");
	By spotted = By.xpath("//a[normalize-space()='EST-4']");
	By spotless = By.xpath("//a[normalize-space()='EST-5']");

	
	By goldFish = By.xpath("//a[normalize-space()='FI-SW-04']");
	By adultMale = By.xpath("//a[normalize-space()='EST-20']");
	By adultFemale = By.xpath("//a[normalize-space()='EST-21']");

	
	
	public JPetStoreFishCategory(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement Anglefish() {
		return driver.findElement(angleFish);
	}
	
	public WebElement LargeAngleFish() {
		return driver.findElement(lagre);
	}
	public WebElement SmallAngleFish() {
		return driver.findElement(small);
	}
	
	public WebElement TigerShark() {
		return driver.findElement(tigerShark);
	}
	public WebElement ToothlessTigerShark() {
		return driver.findElement(toothless);
	}
	
	public WebElement Koi() {
		return driver.findElement(koi);
	}
	public WebElement SpottedKoi() {
		return driver.findElement(spotted);
	}
	public WebElement SpotlessKoi() {
		return driver.findElement(spotless);
	}
	
	public WebElement Goldfish() {
		return driver.findElement(goldFish);
	}
	public WebElement AdultMaleGoldfish() {
		return driver.findElement(adultMale);
	}
	public WebElement AdultFemaleGoldfish() {
		return driver.findElement(adultFemale);
	}
	
}
