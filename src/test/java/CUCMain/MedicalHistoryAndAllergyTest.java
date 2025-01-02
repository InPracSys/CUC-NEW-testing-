package CUCMain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CUC.MedicalHistoryAndAllergy;

public class MedicalHistoryAndAllergyTest {
	WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://azcucptportal.inpracsys.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
}
	@Test
	public void HistoryAllergyExe() throws InterruptedException {
	MedicalHistoryAndAllergy MDHis= new MedicalHistoryAndAllergy(driver);
	MDHis.UserName();
	MDHis.Password1();
	MDHis.Singnapllication();
	MDHis.MedicalFunction();
	MDHis.MedicalHistoryDetails();
	MDHis.PatinetPastHistory();
	MDHis.PatinePastSurgery();
	
	MDHis.PatientSocialHistory();
	MDHis.PatinetFamilyHistory();
//	MDHis.TheAllergyFunction();
	
	
}}