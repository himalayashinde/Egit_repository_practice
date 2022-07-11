package Learning.Selenium;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleniumTrial {

	WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	@BeforeTest
	public void browserProperties() throws Exception 
	{	
		 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		 prop= new Properties();
		
		 prop.load(fis);
	
		 if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		 }
		 else if(prop.getProperty("browser").equalsIgnoreCase("edge")){
			 System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\msedgedriver.exe");
				driver = new EdgeDriver();
		 }
		 else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
				 {
			 System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
		 }
		 
	}
	
	@Test
	public void browserLaunch() throws Exception 
	{
		String url = prop.getProperty("url");
		driver.get(url);
		System.out.println(driver.getTitle());
		
	}
	
	@AfterTest
	public void browserClose() {
		driver.quit();
	}

}
