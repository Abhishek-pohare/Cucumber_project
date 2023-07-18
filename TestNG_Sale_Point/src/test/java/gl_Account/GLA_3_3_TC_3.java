package gl_Account;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Browser_Invoke;

public class GLA_3_3_TC_3 extends Browser_Invoke{
/*
 * check account code field with character inputs.
 */
	@BeforeTest
	private void start() throws InterruptedException {
		super.open();
		super.Login();
		Thread.sleep(2000);
	}
	
	@Test
	private void TC_3() throws InterruptedException {
		//click on Banking module.
				driver.findElement(By.xpath("//div[@class='tabs']/a[7]")).click();
				Thread.sleep(2000);
		//click on GL Accounts tab
		driver.findElement(By.xpath("//div[@id='_page_body']/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/a[1]")).click();
		Thread.sleep(2000);
				
		//enter character account code.
		driver.findElement(By.name("account_code")).clear();
		driver.findElement(By.name("account_code")).sendKeys("abc");
		Thread.sleep(1000);
				
		//as account name is compulsory field so fill some input into it to complete test process.
		driver.findElement(By.name("account_name")).clear();
		driver.findElement(By.name("account_name")).sendKeys("GLA_3.3");
		Thread.sleep(1000);		
		
		//click on add button
				driver.findElement(By.id("add")).click();
				Thread.sleep(2000);
		
		//check using expected message & actual message.
				String Act_Msg= driver.findElement(By.className("err_msg")).getText();
				String Exp_Msg = "The account code must be numeric.";
				try {
					Assert.assertEquals(Act_Msg, Exp_Msg);
					System.out.println("Test Case GLA_3.3_TC_3: Passed ");
				}
				catch(Exception e) {
					System.out.println("Test Case GLA_3.3_TC_3: Failed "+e);
				}
	}
	
	@AfterTest
	private void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
