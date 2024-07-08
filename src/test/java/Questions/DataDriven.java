package Questions;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DataDriven {
WebDriver driver;

	
	@BeforeTest
	public void bt() throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.instagram.com/accounts/login/?hl=en");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		

	}

@Test
public void task() throws IOException {
	
	File EXCEL  = new File("D:\\SDET101\\Book1.xlsx");
	FileInputStream file = new FileInputStream(EXCEL);
	XSSFWorkbook  wb = new XSSFWorkbook(file);
	
	XSSFSheet data = wb.getSheet("Sheet1");
	int row_count = data.getLastRowNum();
	
	for (int i=0;i<=row_count;i++)
	{
		String c1 = data.getRow(i).getCell(0).getStringCellValue();
		String c2 = data.getRow(i).getCell(1).getStringCellValue();
		
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(c1);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(c2);
		driver.findElement(By.xpath("//button[@type='submit']")).click();


	}
}

@AfterTest
public void at() {
	driver.quit();
}

}
