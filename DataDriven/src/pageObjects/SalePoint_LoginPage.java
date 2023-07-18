package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalePoint_LoginPage {

	private static WebElement element;
	
	public static WebElement SalePoint_Username(WebDriver driver) {
		element= driver.findElement(By.name("user_name_entry_field"));
		return element;
	}
	
	public static WebElement SalePoint_Password(WebDriver driver) {
		element= driver.findElement(By.name("password"));
		return element;
	}
	
	public static WebElement Login_Button(WebDriver driver) {
		element= driver.findElement(By.name("SubmitUser"));
		return element;
	}
	
	public static boolean LogintoSalePoint(WebDriver driver, String Username, String Password) throws InterruptedException {
		SalePoint_Username(driver).clear();
		SalePoint_Username(driver).sendKeys(Username);
		SalePoint_Password(driver).clear();
		SalePoint_Password(driver).sendKeys(Password);
		Thread.sleep(2000);
		
		Login_Button(driver).click();
		Thread.sleep(2000);
		
		boolean loginbutton= driver.findElements(By.name("SubmitUser")).size()>0;
		System.out.println(loginbutton);
		return loginbutton;
	}
}
