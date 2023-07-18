package test_cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.OpenBrowser;

//Verify ID field with numeric i/p from GL Account Groups tab

public class GLG_2_2_TC_2 extends OpenBrowser{
	private String Exp_Msg="New account type has been added";
	
	@BeforeMethod
	@Override
	public void Open() {
		// TODO Auto-generated method stub
		super.Open();
	}
	
	@Test
	private void TC_2() throws InterruptedException {
		Thread.sleep(2000);
		
		super.Login();// Call to login function from OpenBrowser class.
		
		Thread.sleep(2000);
		
		//click on GL Account Groups tab
		driver.findElement(By.xpath("//div[@id='_page_body']/table/tbody/tr[3]"
				+ "/td/table/tbody/tr[2]/td[2]/a[2]")).click();
 		Thread.sleep(2000);
 		//Enter numeric value in ID field.
 		driver.findElement(By.xpath("//input[@name='id']")).clear();
 		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("001");
 		Thread.sleep(1500);
 		//just enter any name as it is compulsary field to complete the process
 	    driver.findElement(By.xpath("//input[@name='name']")).clear();
 	    driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Test");
 	    Thread.sleep(1500);
 	    
 	    //click on add new button
 	    driver.findElement(By.xpath("//button[@name='ADD_ITEM']")).click();
 		Thread.sleep(2000);
 		//note message from webpage
 		String Act_Msg= driver.findElement(By.xpath("//div[@id='msgbox']/div")).getText();
 		
 		try{
 			Assert.assertEquals(Act_Msg, Exp_Msg);
 			System.out.println("GLG_2.2_TC_2  Passed");
 		}catch(Exception e) {
 			System.out.println("GLG_2.2_TC_2 Failed"+ e);
 		}
 		
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
}
