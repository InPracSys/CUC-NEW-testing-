package CUCMain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CUC.CUCMedicalRecord;  


public class MedicalRecordTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://azcucptportal.inpracsys.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	
	
	
	@Test
	public void CUCMedicalRecordTestClass() throws InterruptedException {
		CUCMedicalRecord MedRec=new CUCMedicalRecord(driver);
		MedRec.UserName();
		MedRec.Password1();
		MedRec.clickLoginLink();
		MedRec.TheMedicalRecord();
		MedRec.MedSummery();
		MedRec.TreatMents();
		MedRec.allergies();
		MedRec.ActivePrescriptiondetails();
}
}