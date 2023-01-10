package mavenproject.mavenprojectTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
  public static void main(String[] args) {
	  
	  
	//System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Rahul.Yadav\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();	  
	          WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.navigate().to("https://google.com/");
			
    System.out.println("Hello World!");
    driver.close();
  }
}
