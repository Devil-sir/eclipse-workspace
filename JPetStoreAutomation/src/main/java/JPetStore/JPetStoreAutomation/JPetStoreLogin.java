package JPetStore.JPetStoreAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JPetStoreLogin {
	
	WebDriver driver = null;
	
	  public static ExtentTest test; 
	  public static ExtentReports report;
	  
	  @BeforeClass 
	  public static void startTest() { 
		  report = new ExtentReports("C:\\Users\\Rahul.Yadav\\eclipse-workspace\\JPetStoreAutomation\\"+"ExtentReportResults.html");
		  test = report.startTest("ExtentJPetStore"); 
	  }
	 
	
	@Test (dependsOnMethods="invoke")
	public void login() throws IOException, InterruptedException {
		
		FileInputStream fs = new FileInputStream("C:\\Users\\Rahul.Yadav\\eclipse-workspace\\JPetStoreAutomation\\Test Data\\data.properties");
		Properties data = new Properties();
		data.load(fs);
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		
		JPetStoreLoginPage jLogin = new JPetStoreLoginPage(driver);
		jLogin.userName().sendKeys(data.getProperty("userName"));
		jLogin.password().clear();
		jLogin.password().sendKeys(data.getProperty("password"));
		jLogin.login().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ScreenShots();
		
		String actualMsg = driver.findElement(By.xpath("//div[@id='WelcomeContent']")).getText();
		if(actualMsg.equals("Welcome wwwww!")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL and Login Successful!");
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		
		JPetStoreCategory jCategory = new JPetStoreCategory(driver);
		jCategory.Fish().click();
		
		String actualFishTitle = driver.findElement(By.xpath("//h2[normalize-space()='Fish']")).getText();
		if(actualFishTitle.equals("Fish")) {
			test.log(LogStatus.PASS, "Successfully Navigated to the Fish Category Page");
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		
		JPetStoreFishCategory jFish = new JPetStoreFishCategory(driver);
		jFish.Anglefish().click();
		
		String actualAngelFishTitle = driver.findElement(By.xpath("//h2[normalize-space()='Angelfish']")).getText();
		if(actualAngelFishTitle.equals("Angelfish")) {
			test.log(LogStatus.PASS, "Successfully Navigated to the AngelFish Category Page");
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		jFish.LargeAngleFish().click();
		
		
		JPetStoreAddToCart jCart = new JPetStoreAddToCart(driver);
		jCart.AddtoCart().click();
		
		String actualAddtoCartTitle = driver.findElement(By.xpath("//h2[normalize-space()='Shopping Cart']")).getText();
		if(actualAddtoCartTitle.equals("Shopping Cart")) {
			test.log(LogStatus.PASS, "Successfully Navigated to the Add To Cart Page");
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		driver.findElement(By.xpath("//a[normalize-space()='Return to Main Menu']")).click();
		jCategory.Fish().click();
		jFish.Anglefish().click();
		jFish.SmallAngleFish().click();
		jCart.AddtoCart().click();

		jCart.UpdateCart().click();
		test.log(LogStatus.SKIP,"Update cart");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		jCart.Checkout().click();
		test.log(LogStatus.SKIP,"Checkout from cart");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		jCart.NewOrder().click();
		test.log(LogStatus.SKIP,"Continue to Checkout");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		jCart.Confirm().click();
		String actualBillTitle = driver.findElement(By.xpath("//li[normalize-space()='Thank you, your order has been submitted.']")).getText();
		if(actualBillTitle.equals("Thank you, your order has been submitted.")) {
			test.log(LogStatus.PASS, "Checkout Successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ScreenShots();
		
		driver.findElement(By.xpath("//a[normalize-space()='Return to Main Menu']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	@Test 
	@Parameters("browser")
	public void invoke(String browser) throws IOException {
		//String browserName = browser;
		FileInputStream fs = new FileInputStream("C:\\Users\\Rahul.Yadav\\eclipse-workspace\\JPetStoreAutomation\\Test Data\\data.properties");
		Properties data = new Properties();
		data.load(fs);
		if(browser.toLowerCase().equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(data.getProperty("baseurl"));
		}
		else if(browser.toLowerCase().equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(data.getProperty("baseurl"));
		}
		else {
			System.out.print("Enter Vaild Browser Name");
		}
	}
	public void ScreenShots() throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("./Screenshots/"+"Alert-"+System.currentTimeMillis()+".png"));
		System.out.println("Screenshot Successfully added to Images");
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
	
	
	 @AfterClass
	 public static void endTest() { 
		 report.endTest(test);
		 report.flush();
	 }
	 
}
