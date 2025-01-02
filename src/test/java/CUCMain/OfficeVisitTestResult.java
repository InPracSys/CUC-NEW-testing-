package CUCMain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CUC.CUCMedicalRecord;
import CUC.OfficeVisitBase;
import CUC.TestResultBase;

public class OfficeVisitTestResult {

	public class MedicalRecordTest {
		
		WebDriver driver;
		
		@BeforeClass
		public void setup() throws InterruptedException {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Selenium All Jars\\chromedriver_win32 (98)\\chromedriver.exe");
		       
			driver = new ChromeDriver();
			driver.get("https://azcucptportal.inpracsys.com/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
		}
		@Test
		public void CUCMedicalRecordTestClass() throws InterruptedException {
			OfficeVisitBase Visit=new OfficeVisitBase(driver);
			Visit.UserName();
			Visit.Password1();
			Visit.Singnapllication();
			Visit.MedicalFunction();
			Visit.OfficeVisitClick();
			Visit.TheMedicalRecord();
			Visit.MyVisitDetails();
			Visit.SentTheMessage();
			
//			TestResultBase TResult=new TestResultBase(driver);
//			TResult.UserName();
//			TResult.Password1();
//			TResult.Singnapllication();
//			TResult.MedicalFunction();
//			TResult.TheTestResultWindow();
//			TResult.TestResultDetailsList();
//			TResult.OfficeReportdetails();
//		    TResult.Medication();
			
}}}