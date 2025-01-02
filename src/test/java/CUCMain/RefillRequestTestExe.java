package CUCMain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CUC.NewPatientPortalScheduleApp;
import CUC.RefillRequiest;
import io.github.bonigarcia.wdm.WebDriverManager;
public class RefillRequestTestExe {
	
	
		
	WebDriver driver;
		
		@BeforeClass
		public void setup() throws InterruptedException {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Selenium All Jars\\chromedriver_win32 (98)\\chromedriver.exe");
		       
			driver = new ChromeDriver();
			driver.get("https://azcucptportal.inpracsys.com/");
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
		}
		
		
		
		@Test
		public void RefillPatienttabletRequest() throws InterruptedException {
			RefillRequiest ReFill=new RefillRequiest(driver);
			ReFill.UserName();
			ReFill.Password1();
			ReFill.Singnapllication();
			ReFill.refillinkclick();
			ReFill.tables();
			ReFill.TableCheckBox();
			ReFill.closedtheWindows();
			
		}
}
