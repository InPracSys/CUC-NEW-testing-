package TugPCATest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CUC.OfficeVisitBase;
import TUGPCABase.LogIn;

public class Login {
	WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Selenium All Jars\\chromedriver_win32 (98)\\chromedriver.exe");
	       
		driver = new ChromeDriver();
		driver.get("http://tugtest.riskassistapp.com/Login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void CUCMedicalRecordTestClass() throws InterruptedException {
		LogIn logapll=new LogIn(driver);
		logapll.loginapplication();
		

}
}