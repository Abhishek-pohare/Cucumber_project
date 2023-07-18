package gl_Account;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common.Browser_Invoke;

public class TestSuit_GLA_3_11 extends Browser_Invoke {

	
/*	@BeforeSuite
	private void start() throws InterruptedException {
		super.open();
		Thread.sleep(1500);
		super.Login();
	}
*/	
	//verify account name field as empty
	@Test(priority = 3)
	private void TC_11() throws InterruptedException {
		//click on back button
		driver.findElement(By.xpath("//a[text()='Back']")).click();
		String Exp_Msg= "The account name cannot be empty.";
		Thread.sleep(2000);
		
		//click on GL Account tab
		driver.findElement(By.xpath("//div[@id='_page_body']/table/tbody/tr[3]"
				+ "/td/table/tbody/tr[2]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		//
		driver.findElement(By.xpath("//input[@name='account_code']")).clear();
		driver.findElement(By.xpath("//input[@name='account_code']")).sendKeys("0");
		
		//do not enter any value in account name field
		driver.findElement(By.xpath("//button[@value='Add Account']")).click();
		//
		String Act_Msg= driver.findElement(By.xpath("//div[@id='msgbox']/div")).getText();
		
		try {
			Assert.assertEquals(Exp_Msg, Act_Msg);
			System.out.println("Test Case 11 Passed");
			
		}
		catch(Exception e) {
			System.out.println("Test case 11 Failed"+ e);
		}
	}

	/*
	 * TC_12= verify account name field with numeric inputs-- it should fail 
	 * account name cannot be numeric
	 */
	@Test(priority = 4)
	private void TC_12() throws InterruptedException {
		Thread.sleep(2000);
		
		//expected Error message.
		String Exp_nameMSG= "The account name must be character.";
		
		//enter numeric value in account name field
		driver.findElement(By.xpath("//input[@name='account_name']")).clear();
		driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys("00");
		//
		driver.findElement(By.xpath("//button[@value='Add Account']")).click();
		//
		String Act_nameMSG= driver.findElement(By.xpath("//div[@id='msgbox']/div")).getText();
		
		try {
			
			Assert.assertEquals(Exp_nameMSG, Act_nameMSG);
			System.out.println("Test Case 12 Passed");
		}
		catch(Exception ne) {
			System.out.println("Test Case 12 Failed"+ne);
		}
		
	}
	
	@AfterSuite
	private void Quit() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
