package Questions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {
	
	WebDriver driver;
	
	@BeforeTest
	public void bt() {
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws InterruptedException {
		
		WebElement upload = driver.findElement(By.id("input-4"));
		
		String file = "C:\\Users\\singh\\Pictures\\wmb1.png";
		Thread.sleep(4000);
		upload.sendKeys(file);
		
		
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		
		
	}
	
	@AfterTest
	public void at() {
		
		driver.quit();
		
	}

}
