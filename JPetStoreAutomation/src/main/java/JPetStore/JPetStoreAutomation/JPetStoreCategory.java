package JPetStore.JPetStoreAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JPetStoreCategory {
	WebDriver driver = null;
	By fish = By.xpath("//img[@src='../images/sm_fish.gif']");
	By dogs = By.xpath("//img[@src='../images/sm_dogs.gif']");
	By reptiles = By.xpath("//img[@src='../images/sm_reptiles.gif']");
	By cats = By.xpath("//img[@src='../images/sm_cats.gif']");
	By birds = By.xpath("//img[@src='../images/sm_birds.gif']");
	
	public JPetStoreCategory(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement Fish() {
		return driver.findElement(fish);
	}
	
	public WebElement Dogs() {
		return driver.findElement(dogs);
	}
	
	public WebElement Reptiles() {
		return driver.findElement(reptiles);
	}
	
	public WebElement Cats() {
		return driver.findElement(cats);
	}
	
	public WebElement Birds() {
		return driver.findElement(birds);
	}
}
