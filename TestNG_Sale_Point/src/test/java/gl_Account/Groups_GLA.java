package gl_Account;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Login;

public class Groups_GLA extends Login {

	@Test(groups = {"Regression"})
	private void start() {
		OpenBrowser();
	}
	
	@Test(groups = {"Regression"},dependsOnMethods = {"start"})
	private void login() throws InterruptedException {
		GoToLogin();
	}
	
	@Test(groups = {"Regression"},dependsOnMethods = {"login"})
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
	
	@Test(groups = {"Regression"},dependsOnMethods = {"TC_3"})
	private void GLA_TC_4() throws InterruptedException {
		//1. click on Banking and GL module.
		ClickOn_Banking_And_GL();
		Thread.sleep(2000);
		
		//click on GL Accounts tab.
		driver.findElement(By.xpath("//div[@id='_page_body']/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		
		//Enter symbolic value in account code field
		driver.findElement(By.name("account_code")).clear();
		driver.findElement(By.name("account_code")).sendKeys("#@$$ab1");
		Thread.sleep(2000);
		
		//to complete the test process enter value in account name field as it is compulsory field.
		driver.findElement(By.name("account_name")).sendKeys("GLA_3.4_TC_4");
		Thread.sleep(2000);
		
		//click on add button.
		driver.findElement(By.id("add")).click();
		Thread.sleep(4000);
		
		//verify Test Case using actual & expected message.
		String Exp_msg="The account code must be numeric.";
		String Act_msg=driver.findElement(By.xpath("//div[@id='msgbox']/div")).getText();
		try {
			Assert.assertEquals(Act_msg, Exp_msg);
			System.out.println("Test Case GLA_3.4_TC_4: Passed");
		}
		catch(Exception e) {
			System.out.println("Test Case GLA_3.4_TC_4: Failed");
			System.out.println(e);
		}
		
		//take screen shot of page.
		TakesScreenshot ss= ((TakesScreenshot)driver);
		File f= ss.getScreenshotAs(OutputType.FILE);
		String ssFile= "GLA_3.4_TC4(grp)";
		
		String capturePath="C:\\Users\\Abhishek\\OneDrive\\Desktop\\Auto_SalePoint\\ScreenShots\\"+ssFile+".png";
		try {
			//save screenshot
			FileHandler.copy(f,new File(capturePath));
		}
		catch(Exception e1) {
			System.out.println("Screenshot capture failed: ");
			System.out.println(e1);
		}
	}
	
	@Test(groups = {"Regression"}, dependsOnMethods = {"GLA_TC_4"})
	private void close() {
		
		driver.close();
	}
	
	
}
