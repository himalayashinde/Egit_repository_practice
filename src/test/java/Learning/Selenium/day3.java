package Learning.Selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day3 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite is having highest Priority...!!!");
	}

	@BeforeMethod
	public void beforeEveryMethod(){
		System.out.println("I will execute after every testcase in day 3......######");
	}
	
	@Test(timeOut=4000)
	public void webLoginPersonalLoan() {
		System.out.println("webLoginPersonalLoan");
	}
	
	@Test(enabled=false)
	public void MobileLoginPersonalLoan() {
		System.out.println("MobileLoginPersonalLoan");
	}
	
	
	@Test(groups={"Smoke"})
	public void APILoginPersonalLoan() {
	}
	
	@Test(dependsOnMethods= {"webLoginPersonalLoan"})
	public void APILoginCarLoan() {
		System.out.println("APILoginCarLoan");
	}
	
	
	@Test(dataProvider="getData")
	public void webLoginPersonalLoanDataproviderexample(String uname, String pass) {
		System.out.println("webLoginPersonalLoanDataproviderexample");
		System.out.println("Uname="+ uname + " password= "+ pass);
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "firstname";
		data[0][1] = "firstpassword";

		data[1][0] = "Secondtname";
		data[1][1] = "Secondpassword";
		
		data[2][0] = "Thirdname";
		data[2][1] = "Thirdpassword";
		
		return data;
	}
}
