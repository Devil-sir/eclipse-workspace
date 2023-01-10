package mavenproject.mavenprojectTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class testNgPriorityGroupingExample {
	@BeforeTest
	public static void invokeBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https:\\www.google.com\\");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//driver.switchTo().window(tabs.get(1));
		
		driver.close();
	}
	@Test (groups = {"add"},priority = 1)
	public void add() {
		int a = 3, b = 4;
		System.out.println(a + b);
	}
	
	@Test (groups = {"sub"},priority = 0)
	@Parameters({"val1","val2"})
	public void sub(int a,int b) {
		//int a = 5, b = 1;
		System.out.println(a - b);
	}
	@Test (groups = {"sub"},priority = 2)
	public void mul() {
		System.out.println(9*2);
	}
}
