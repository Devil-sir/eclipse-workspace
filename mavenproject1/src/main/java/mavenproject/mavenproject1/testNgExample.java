package mavenproject.mavenproject1;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testNgExample {
	
	FileInputStream fs = null;
	XSSFWorkbook  workbook;
	
	
	
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
	public void readExcel() throws FileNotFoundException {
		FileInputStream fs = new FileInputStream("");
		
	}
	/*
	 * FileInputStream fis = nnew FileInputStream(filke path);
	 * workbook = new XSSFWorkbook(fis);
	 * sheet  = workbook .getShetAt(0);
	 * int row = sheet.getPhysicalNumberOfRows();\
	 * int col = sheet.getRow(0).getLastCellNum();
	 * for(int i = 0; i < row; i++ ){
	 * for(int j= 0; j < col;j++){
	 * S.o.p(getCellDataString(i,j)+" ");
	 * }
	 * s.o.pln();
	 * }
	*/
}
