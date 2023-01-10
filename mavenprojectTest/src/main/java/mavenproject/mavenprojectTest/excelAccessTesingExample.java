package mavenproject.mavenprojectTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelAccessTesingExample {

	static FileInputStream fs = null;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public static  String getCellDataString(int row, int col) {
		String cellData = null;
		cellData = sheet.getRow(row).getCell(col).getStringCellValue();
		return cellData;
	}

	public static void readExcel() throws IOException {
		fs = new FileInputStream("C:\\Users\\Rahul.Yadav\\Desktop\\data.xlsx");
		workbook = new XSSFWorkbook(fs);
		sheet  = workbook .getSheetAt(0);
		System.out.print(sheet.getRow(0));
		
		int row = sheet.getPhysicalNumberOfRows();
		System.out.println("No. of Rows"+row);
		int col = sheet.getRow(0).getLastCellNum();
		System.out.println("No. opf Column"+col);
		for(int i = 0; i < row; i++ ){
			for(int j= 0; j < col;j++){
				System.out.print(getCellDataString(i,j)+" ");
		}
		System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		readExcel();
	}
	
}
