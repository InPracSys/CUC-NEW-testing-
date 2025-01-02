package CUCMain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CUC.CorrespondenceBase;
import CUC.MessageWriteToClinicANdCorrespondance;

public class CorrespondenceTestMessageWrite {
  
	WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://azcucptportal.inpracsys.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
}
	@Test
//	public void CorrespondanceExe() throws InterruptedException {
//		CorrespondenceBase Corres= new CorrespondenceBase(driver);
//		Corres.UserName();
//		Corres.Password1();
//		Corres.Singnapllication();
//		Corres.CorrespandanceFunctinDetails();
//	}
	public void MessageWriteEXe() throws InterruptedException {
		MessageWriteToClinicANdCorrespondance Mesage= new MessageWriteToClinicANdCorrespondance(driver);
		Mesage.UserName();
		Mesage.Password1();
		Mesage.Singnapllication();
		Mesage.Messagebuttonclick();
		Mesage.SubjectSent();
		Mesage.TextwriteSentMessage();
		Mesage.CloseThePopup();
		
	}
}
