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

public class checkBox {

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
		String url = prop.getProperty("checkboxurl");

		driver.get(url);
		System.out.println(driver.getTitle() + " " + driver.getCurrentUrl());

		driver.findElement(By.cssSelector("button[aria-label='Expand all']")).click();

		driver.findElement(By.className("rct-checkbox")).click();

		Thread.sleep(3000);

		System.out.println(driver.findElement(By.id("result")).getText());

		Thread.sleep(3000);

		driver.findElement(By.className("rct-checkbox")).click();

		Thread.sleep(2000);
		
		 
	}

	@AfterTest
	public void browserQuit() {
		driver.quit();
	}

}
