package gl_Account;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Browser_Invoke;

//GLA_3.2_TC_2= check Account code field with numeric inputs.

public class GLA_3_2_TC_2 extends Browser_Invoke{

	@BeforeTest
	private void Start() throws InterruptedException {
		super.open();
		Thread.sleep(2000);
		super.Login();
		Thread.sleep(2000);
	}
	
	@Test
	private void TC_2() throws InterruptedException {
		//click on Banking module.
		driver.findElement(By.xpath("//div[@class='tabs']/a[7]")).click();
		Thread.sleep(2000);
		
		//click on GL Accounts tab
		driver.findElement(By.xpath("//div[@id='_page_body']/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		
		//enter numeric account code.
		driver.findElement(By.name("account_code")).clear();
		driver.findElement(By.name("account_code")).sendKeys("01");
		Thread.sleep(1000);
		
		//as account name is compulsory field so fill some input into it to complete test process.
		driver.findElement(By.name("account_name")).clear();
		driver.findElement(By.name("account_name")).sendKeys("GLA_3.2");
		Thread.sleep(1000);
		
		//click on add button
		driver.findElement(By.id("add")).click();
		Thread.sleep(2000);
		//check using expected message & actual message.
		String Act_Msg= driver.findElement(By.className("note_msg")).getText();
		String Exp_Msg = "New account has been added.";
		try {
			Assert.assertEquals(Act_Msg, Exp_Msg);
			System.out.println("Test Case GLA_3.2_TC_2: Passed ");
		}
		catch(Exception e) {
			System.out.println("Test Case GLA_3.2_TC_2: Failed "+e);
		}
		
	}
	
	@AfterTest
	private void quite() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
