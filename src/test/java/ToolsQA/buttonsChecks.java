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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class buttonsChecks {

	WebDriver driver;
	FileInputStream fis;
	Properties prop;
	Actions act;

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
	public void clickingButtons() throws Exception {
		String url = prop.getProperty("buttonurl");

		driver.get(url);
		System.out.println(driver.getTitle() + " " + driver.getCurrentUrl());
		
		act= new Actions(driver);
		
		WebElement doubleClickit = driver.findElement(By.id("doubleClickBtn"));
		act.doubleClick(doubleClickit).perform();
		
		System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());
		
		WebElement rightClickMe = driver.findElement(By.id("rightClickBtn"));
		
		act.contextClick(rightClickMe).perform();
		
		System.out.println(driver.findElement(By.id("rightClickMessage")).getText());
		
		WebElement dynamicClickMe= driver.findElement(By.xpath("//button[.='Click Me']"));
		
		act.click(dynamicClickMe).perform();
		 
		
		//System.out.println("Button is available or not :=" +driver.findElement(By.xpath("//button[.='Click Me']")).isEnabled());
		
		
		System.out.println(driver.findElement(By.id("dynamicClickMessage")).getText());
	}

	@AfterTest
	public void browserQuit() {
		driver.quit();
	}

}
