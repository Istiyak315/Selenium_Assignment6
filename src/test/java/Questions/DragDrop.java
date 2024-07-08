package Questions;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DragDrop {
	
	WebDriver driver;
	
	@BeforeTest
	public void bt() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://v1.training-support.net/selenium/drag-drop");
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void test1() throws IOException, InterruptedException {
		TakesScreenshot before = (TakesScreenshot)driver;
		File ot = before.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ot,new File("D:\\SDET101\\before.png"));
		
		WebElement drag = driver.findElement(By.xpath("//img[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(4000);
		
		
		TakesScreenshot after = (TakesScreenshot)driver;
		File ot1 = after.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ot1,new File("D:\\SDET101\\after.png"));

     
	}
	
	@AfterTest
	public void at() {
		//driver.quit();
	}

}
