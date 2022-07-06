package ToolsQA;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class radioButtonChecks {

	WebDriver driver;
	FileInputStream fis;
	Properties prop;

	@BeforeTest
	public void browserProperties() throws Exception {

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");

		prop = new Properties();
		prop.load(fis);

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void clickingChecktBox() throws Exception {
		String url = prop.getProperty("radiobuttonurl");

		driver.get(url);
		System.out.println(driver.getTitle() + " " + driver.getCurrentUrl());

		try {
		driver.findElement(By.id("yesRadio")).click();
		}
		catch(Exception e) {
			System.out.println("Inside Catch Block Executed ....####");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].click();", driver.findElement(By.id("yesRadio")));
		}
		System.out.println(driver.findElement(By.id("yesRadio")).getText());
		
		System.out.println(driver.findElement(By.className("mt-3")).getText());
		
		//impressiveRadio
		
		
		try {
			driver.findElement(By.id("impressiveRadio")).click();
			}
			catch(Exception e) {
				System.out.println("Inside Catch Block Executed ....####");
				JavascriptExecutor executor = (JavascriptExecutor) driver;
			    executor.executeScript("arguments[0].click();", driver.findElement(By.id("impressiveRadio")));
			}
			System.out.println(driver.findElement(By.id("impressiveRadio")).getText());
			
			System.out.println(driver.findElement(By.className("mt-3")).getText()+"\n");
			
		System.out.println("No radio button Status := " + driver.findElement(By.id("noRadio")).isEnabled());
		
	}

	@AfterTest
	public void browserQuit() {
		driver.quit();
	}

}
