package gl_Account;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Browser_Invoke;

public class TestSuit_GLA_3_1 extends Browser_Invoke {

	@BeforeSuite
	private void start() throws InterruptedException {
		super.open();
		Thread.sleep(2000);
		super.Login();
	} 
	
/*	@BeforeTest
	private void Login1() throws InterruptedException {
		super.Login();
	}
*/	
	@Test (priority = 1)
	private void GLA_3_1_TC_1() throws InterruptedException{
		String Exp_msg="The account code must be entered.";

		Thread.sleep(2000);
		//click on GL Accounts tab
		driver.findElement(By.xpath("//div[@id='_page_body']/table/tbody/tr[3]"
				+ "/td/table/tbody/tr[2]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		
		//do not enter any value in account code. click on add button
		driver.findElement(By.xpath("//button[@value='Add Account']")).click();
		Thread.sleep(1500);
		
		String Act_msg= driver.findElement(By.xpath("//div[@id='msgbox']/div")).getText();
		try {
			Assert.assertEquals(Act_msg, Exp_msg);
			System.out.println("Test Case: GLA_3.1_TC_1 Passed");
		}
		catch(Exception e) {
			System.out.println("Test Case: GLA_3.1_TC_1 Failed"+ e);
		}
		
	}
	
/*	@AfterTest
	private void Close1() {
		driver.close();
	}
	
	@BeforeTest
	private void Login2() throws InterruptedException {
		super.Login();
	}
*/	
	@Test (priority = 2)
	private void GLA_3_1_TC_2() throws InterruptedException {
		String Exp_msg2="New account has been added.";
		
		Thread.sleep(2000);
		//click on GL Accounts tab
	/*	driver.findElement(By.xpath("//div[@id='_page_body']/table/tbody/tr[3]"
				+ "/td/table/tbody/tr[2]/td[2]/a[1]")).click();
		Thread.sleep(2000);
	*/	
		//enter a numeric value in Account Code field
		 driver.findElement(By.xpath("//input[@name='account_code']")).clear();
		 driver.findElement(By.xpath("//input[@name='account_code']")).sendKeys("009");
		 Thread.sleep(1500);
		
		 //enter some value in Account name field to complete process as it is compulsory field
		driver.findElement(By.xpath("//input[@name='account_name']")).clear();
		driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys("Test9");
		Thread.sleep(1500);
		
		// click on add button
		driver.findElement(By.xpath("//button[@value='Add Account']")).click();
		Thread.sleep(1500);
		
		String Act_msg= driver.findElement(By.xpath("//div[@id='msgbox']/div")).getText();
		try {
			Assert.assertEquals(Act_msg, Exp_msg2);
			System.out.println("Test Case: GLA_3.1_TC_1 Passed");
		}
		catch(Exception e) {
			System.out.println("Test Case: GLA_3.1_TC_1 Failed"+ e);
		}
		Thread.sleep(2000);
	}
	
/*	@AfterTest
	private void close2() {
		driver.close();
	}
*/	
	
/*	@AfterSuite
	private void suiteClose() {
		driver.close();
	}
*/	
}
