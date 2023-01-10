package seleniumDemo;

import java.io.File;
import java.io.IOException;
import java.util.*;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;

public class testing {
	public static void main(String[] args) throws InterruptedException {
		choose();
	}
	public static void choose() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Borwser Name:");
		String borwser = sc.nextLine();
		sc.close();
		if(borwser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul.Yadav\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver wb = new ChromeDriver();
			
			wb.get("https://demo.guru99.com/test/newtours/register.php");
			seleniumInput(wb);

			//getSuggestion(wb);

		}
		else if(borwser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Rahul.Yadav\\Downloads\\edgedriver_win64\\\\msedgedriver.exe");
			WebDriver wb = new EdgeDriver();
			
			wb.get("https://www.google.com/");
			getSuggestion(wb);
			
		}
		else {
			System.out.println("Enter correct Web Borwser!!!!!");
		}
	}
	public static void getSuggestion(WebDriver wb) throws InterruptedException {
			WebElement textBox = wb.findElement(By.name("q"));
			textBox.sendKeys("automation");
			Thread.sleep(80000);
			//textBox.sendKeys(Keys.ENTER);
			long end = System.currentTimeMillis() + 5000; while
			(System.currentTimeMillis() < end) { 
				WebElement resultDiv = wb.findElement(By.className("UUbT9"));
			  
				if (resultDiv.isDisplayed()) { break; } }
			 
			List<WebElement> option = wb.findElements(By.xpath("/html/body/div/div[3]/form/div/div/div[2]/div/div/ul"));
			for(WebElement w: option) {
				System.out.println(w.getText());
			}
			//Files.copy(f, new File(""));
	        try {
	    		File f = ((TakesScreenshot) wb).getScreenshotAs(OutputType.FILE);
				Files.copy(f, new File("./Images/"+"Alert-"+System.currentTimeMillis()+".png"));
				System.out.println("Screenshot Successfully added to Images");
			} 
	        catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	        wb.close();
	}
	public static void seleniumInput(WebDriver driver) throws InterruptedException {
		/*
		 * long end = System.currentTimeMillis() + 5000; while
		 * (System.currentTimeMillis() < end) { WebElement resultDiv =
		 * driver.findElement(By.name("country"));
		 * 
		 * if (resultDiv.isDisplayed()) { break; } }
		 */
		
		try {
			Thread.sleep(80000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		firstName.sendKeys("Ramesh");
		Thread.sleep(80000);

		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastName.sendKeys("Yadav");
		Thread.sleep(80000);

		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("7894561232");
		Thread.sleep(80000);

		WebElement email = driver.findElement(By.xpath("//input[@name='userName']"));
		email.sendKeys("Rameshyadav@hotmail.com");
		Thread.sleep(80000);

		List<WebElement> countries = driver.findElements(By.xpath("//select[@name='country']"));
		System.out.println("Countries:");
		Thread.sleep(80000);

		for(WebElement wb : countries) {
			System.out.println(wb.getText());
		}
	}
	

}
