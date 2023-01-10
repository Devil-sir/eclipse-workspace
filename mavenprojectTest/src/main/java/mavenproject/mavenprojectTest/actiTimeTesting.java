package mavenproject.mavenprojectTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actiTimeTesting {
	
	public static WebDriver InvokeBrowser(String browser) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			 driver.get("https:\\www.google.com\\");
			 return driver;
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			 driver.get("https:\\www.google.com\\");
			 return driver;
		}
		else {
			System.out.print("Enter Correct Browser Name");
		}
		return null;
	}
	public static void screenShots(WebDriver wb) throws IOException {
		File f = ((TakesScreenshot) wb).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("./Screenshots/"+"Alert-"+System.currentTimeMillis()+".png"));
		System.out.println("Screenshot Successfully added to Images");
	}
	public static void closeBrowser(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fs = new FileInputStream("C:\\Users\\Rahul.Yadav\\eclipse-workspace\\mavenproject1\\src\\main\\java\\mavenproject\\mavenproject1\\data.properties");
		Properties data = new Properties();
		data.load(fs);
		System.out.print(data.getProperty("browser"));
		WebDriver driver = InvokeBrowser(data.getProperty("browser"));
		/*
		 * String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
		 * driver.findElement(By.linkText(data.getProperty("baseurl"))).sendKeys(
		 * selectLinkOpeninNewTab);
		 */
		driver.navigate().to(data.getProperty("baseurl"));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(data.getProperty("userName"));
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(data.getProperty("password"));
		driver.findElement(By.xpath("//div[normalize-space()='Login']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement logout = driver.findElement(By.xpath("//a[@id='logoutLink']"));

		wait.until(ExpectedConditions.elementToBeClickable(logout));
		screenShots(driver);
		logout.click();
		
		closeBrowser(driver);
		
	}

}
