package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalePoint_HomePage {

	private static WebElement element;
	
	public static WebElement Logout_Button(WebDriver driver) {
		element= driver.findElement
				(By.xpath("/html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[1]/td[3]/a[5]"));
		return element;
	}
	
	public static void Logout_SalePoint(WebDriver driver) throws InterruptedException {
		Logout_Button(driver).click();
		Thread.sleep(2000);
	}
}
