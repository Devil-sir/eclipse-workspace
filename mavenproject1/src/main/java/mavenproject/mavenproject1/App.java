package mavenproject.mavenproject1;

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
		try {
			driver.manage().wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().to("https://google.com/");
		
    //System.out.println("Hello World!");
  }
}
