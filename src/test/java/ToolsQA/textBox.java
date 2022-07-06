package ToolsQA;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class textBox {
	
	WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	
	@BeforeTest
	public void browserProperties() throws Exception {
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");

		prop = new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void fillingTextBox() throws Exception
	{
		String url = prop.getProperty("textboxurl");
		
		driver.get(url);
		System.out.println(driver.getTitle() + " " + driver.getCurrentUrl() );
		
		driver.findElement(By.id("userName")).sendKeys(prop.getProperty("fullName"));
		driver.findElement(By.id("userEmail")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("currentAddress")).sendKeys(prop.getProperty("currentAddress"));
		driver.findElement(By.id("permanentAddress")).sendKeys(prop.getProperty("permanentAddress"));
		
		try {
				driver.findElement(By.id("submit")).click();
			}
		catch(Exception e) {
			System.out.println("Inside Catch Block Executed ....####");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
		}
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("output")).getText());
		
	}
	
	
	@AfterTest
	public void browserQuit() {
		driver.quit();
	}
	
}


/*
OUTPUT as Below

ToolsQA https://demoqa.com/text-box
Name:Himalaya Shinde
Email:himalaya@gmail.com
Current Address :dighi alandi
Permananet Address :ALANDI ROAD PUNE
PASSED: fillingTextBox

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================




*/