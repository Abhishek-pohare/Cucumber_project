package payments;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.SP_Login;

/*
 * Demo for processing payment.
 */
public class Process_Payment extends SP_Login {

	@BeforeTest
	private void Start() throws InterruptedException {
		super.BrowserInvoke();
		super.Login();
		Thread.sleep(2000);
	}
	
	@Test
	private void PM_TC_1() throws InterruptedException {
		super.ClickOn_Banking_And_GL();
		Thread.sleep(2000);
		
		//Click on Payments tab
		driver.findElement(By.xpath("//div[@id='_page_body']//following::a[text()='ayments']")).click();
		Thread.sleep(2000);
		
		//click on date
		driver.findElement(By.xpath("//div[@id='pmt_header']/center/table/tbody/tr/td"
				+ "/table/tbody/tr/td[2]/a[@tabindex='-1']")).click();
		Thread.sleep(1500);
		
		//select date
		driver.findElement(By.xpath("//div[@id='CC']/table/tbody/tr[4]/td[3]")).click();
		Thread.sleep(2000);
		
		//select pay to
		Select s= new Select(driver.findElement(By.xpath("//select[@name='PayType']")));
		s.selectByVisibleText("Customer");
		Thread.sleep(1000);
		
		Select s1= new Select(driver.findElement(By.xpath("//select[@name='bank_account']")));
		s1.selectByVisibleText("Petty Cash account");
		Thread.sleep(1000);
		
		Select s2= new Select(driver.findElement(By.xpath("//select[@name='code_id']")));
		s2.selectByVisibleText("1200    Accounts Receivables");
		Thread.sleep(1000);
		
		//enter amount
		driver.findElement(By.name("amount")).clear();
		driver.findElement(By.name("amount")).sendKeys("207");
		Thread.sleep(1000);
		driver.findElement(By.name("LineMemo")).sendKeys("Test Process");
		Thread.sleep(1000);
		
		//click on add buton
		driver.findElement(By.xpath("//button[@id='AddItem']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@value='Process Payment']")).click();
		Thread.sleep(2500);
	}
	
	@AfterTest
	private void close() {
		driver.close();
	}
}
