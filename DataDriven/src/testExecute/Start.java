package testExecute;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.SalePoint_HomePage;
import pageObjects.SalePoint_LoginPage;
import utility.Constants;
import utility.Excel_Utility;

public class Start {

	private static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		Excel_Utility.setExcelFile(Constants.data_Path+Constants.Data_file,"Sheet1");
		int excelrowcount= Excel_Utility.lastRow();
		System.out.println(excelrowcount);
		
		for(int i=1;i<=excelrowcount;i++) {
			String sUserName= Excel_Utility.getCellData(i, 1);
			String sPassword= Excel_Utility.getCellData(i, 2);
			BrowserInvoke();
			boolean loginsuccess=  SalePoint_LoginPage.LogintoSalePoint(driver, sUserName, sPassword);
			if(loginsuccess==false) {
				SalePoint_HomePage.Logout_SalePoint(driver);
				Excel_Utility.setCellData("Pass", i, 3);
			}
			else {
				Excel_Utility.setCellData("Fail", i, 3);
			}
			System.out.println("done");
			driver.close();
		}
	}
	
	public static void BrowserInvoke() {
		ChromeOptions ch= new ChromeOptions();
		ch.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Abhishek\\OneDrive\\Desktop\\JAVA_JARS\\driver\\chromedriver.exe");
		driver= new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constants.URL);
	}
}
