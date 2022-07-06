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

public class AutomationPracticeForm {

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
		String url = prop.getProperty("automationformurl");

		driver.get(url);
		System.out.println(driver.getTitle() + " " + driver.getCurrentUrl());

		driver.findElement(By.id("firstName")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("lastName")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("lastName")).sendKeys(prop.getProperty("lastName"));

		driver.findElement(By.id("userEmail")).sendKeys(prop.getProperty("email"));

		WebElement radio1 = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

		try{
			
				radio1.click();
		   }
		catch (Exception e) {
				
			System.out.println("Clicked using catch block");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",radio1);

		}
		
		driver.findElement(By.id("userNumber")).sendKeys(prop.getProperty("userNumber"));

		
		WebElement DatePicker =driver.findElement(By.id("dateOfBirthInput"));
		
		DatePicker.click();
		
		Thread.sleep(2000);

		WebElement month=driver.findElement(By.xpath("//div[@class='react-datepicker__month-container']/div[@class='react-datepicker__header']/div[2]/div[1]/select/option[9]"));
		
		month.click();
		
		Thread.sleep(2000);
		
		WebElement year=driver.findElement(By.xpath("//div[@class='react-datepicker__month-container']/div[@class='react-datepicker__header']/div[2]/div[2]/select/option[@value='1992']"));
		
		year.click();
		
		Thread.sleep(2000);
		
		WebElement date= driver.findElement(By.xpath("//div[@class='react-datepicker__month-container']/div[@class='react-datepicker__month']/div[1]/div[4]"));
		
		date.click();
		
		Thread.sleep(3000);

		WebElement Subjects= driver.findElement(By.cssSelector("div[class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
		
		Subjects.click();
		
		Subjects.sendKeys("s");
	}

	@AfterTest
	public void browserQuit() {
		//driver.quit();
	}

}
