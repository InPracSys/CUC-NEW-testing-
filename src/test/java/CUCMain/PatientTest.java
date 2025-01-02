package CUCMain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CUC.NewPatientPortalScheduleApp;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientTest {
	
WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://azcucptportal.inpracsys.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	
	
	
	@Test
	public void CUCRagistrationTest() throws InterruptedException {
	
		NewPatientPortalScheduleApp rgPage= new NewPatientPortalScheduleApp(driver);
		rgPage.UserName();
		rgPage.Password1();
		rgPage.clickLoginLink();
		rgPage.SchedulePatientAppointm();
		rgPage.ReasonVisit();
		rgPage.SelectDateFromCalendar(driver, "25");
		rgPage.SelectToDateCalendar(driver, "09/09/2024");
		rgPage.checkboxwensday(driver);
		rgPage.TextsentToClinic();
		//rgPage.CancelButtonClick();
		//rgPage.SaveTheMessage();
	}

}
