package Learning.Selenium;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {

	
	@AfterTest
	public void lastexecution() {
		System.out.println("I will execute AfterTests are completed");
	}
	
	@BeforeTest
	public void prerequisite(){
		System.out.println("I will execute this first Before all the test starts");
	}
	
	@Test(groups={"Smoke"})
	public void webLoginHomeLoan() {
		System.out.println("webLoginHomeLoan");
	}
	
	@Parameters({"URL"})
	@Test
	public void MobileLoginHomeLoan(String urlName) {
		System.out.println("MobileLoginHomeLoan" +" " + urlName);
	}
	
	
	@Test
	public void APILoginHomeLoan() {
		System.out.println("APILoginHomeLoan");
	}
	
	
}
