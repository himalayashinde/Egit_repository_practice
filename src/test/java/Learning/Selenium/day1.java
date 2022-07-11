package Learning.Selenium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {

	@Test
	public void webLoginCarLoan() {
		System.out.println("webLoginCarLoan");
	}
	
	@Parameters({"URL"})
	@Test
	public void MobileLoginCarLoan(String urlname) {
		System.out.println("MobileLoginCarLoan" +" "+ urlname);
	}
	
	
	@Test(groups={"Smoke"})
	public void APILoginCarLoan() {
		System.out.println("APILoginCarLoan");
	}
	
	@AfterSuite
	public void aftersuite(){
		System.out.println("AfterSuite have the least priority...!!!");
	}
}
