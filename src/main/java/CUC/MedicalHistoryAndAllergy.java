package CUC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicalHistoryAndAllergy {

	  WebDriver driver;
		// Declaration
				@FindBy(xpath="//input[@id='UserName']") private WebElement reg_username;
				@FindBy(xpath="//input[@id='Passwd']") private WebElement Password;
				@FindBy(xpath="//button[@class='btn btn-block LoginBt']") private WebElement SignInApp;
				@FindBy(xpath = "//div[@class='left_panel text-center']/div[2]") private WebElement medicalRecord;
	            @FindBy(xpath="//ul[@id='MedRc']/li[6]") private WebElement MedicalHistory;  
	            @FindBy(xpath="//div[@id='MEDICAL']/div") private WebElement ListOfComponant;
	            @FindBy(xpath="//div[@id='MEDICAL']/div[2]/div/h4/a/span") private WebElement PastHistory;
	            @FindBy(xpath="//div[@id='MEDICAL']/div[3]/div/h4/a/span") private WebElement PastSurgery;
	            @FindBy(xpath="//div[@id='MEDICAL']/div[4]/div/h4/a/span") private WebElement SocialHistory;
	            @FindBy(xpath="//div[@id='MEDICAL']/div[5]/div/h4/a/span") private WebElement FamilyHistory;
	            @FindBy(xpath="//ul[@id='MedRc']/li[7]") private WebElement Allergies; 
 public MedicalHistoryAndAllergy( WebDriver driver) {
	         this.driver = driver;

	         PageFactory.initElements(driver, this);
	            	
	            }
    public void UserName() {
	         reg_username.sendKeys("TestBw");
	            }


   public void Password1() {
	         Password.sendKeys("Test@1234");
	            }
   public void Singnapllication() {
	          SignInApp.click();
	            }

   public void MedicalFunction() {
		medicalRecord.click();
	}
   public void MedicalHistoryDetails() throws InterruptedException {
	    MedicalHistory.click();
	    List<WebElement> listMed = driver.findElements(By.xpath("//*[@id=\"MEDICAL\"]/div"));
	    System.out.println("Number of medical history records: " + listMed.size());
	    for(WebElement ListRecord :listMed) {
	    	Thread.sleep(4000);
	    	String Records= ListRecord.getText();
	    	System.out.println(Records);
	    	
	    }
	}
   public void PatinetPastHistory() throws InterruptedException {
	   MedicalHistory.click();
	   
	    List<WebElement> PTHistory = driver.findElements(By.xpath("//div[@id='MEDICAL']/div[2]/div[2]/div/div[1]/div"));
	    System.out.println("Patinet past history records: " + PTHistory.size());
	    for(WebElement ListRecord :PTHistory) {
	    	
	    	String Records= ListRecord.getText();
	    	Thread.sleep(2000);
	    	System.out.println(Records);
	    }
	    System.out.println("+++++++The Patient Past History+++++++++++++++++++++++++++");
    }
public void PatinePastSurgery() throws InterruptedException {
		PastSurgery.click();
	    List<WebElement> PTSurgery = driver.findElements(By.xpath("//div[@id='MEDICAL']/div[3]/div[2]/div/div[1]/div"));
	 	    System.out.println("Patinet Surgery history records: " + PTSurgery.size());
	 	    for(WebElement ListRecord2 :PTSurgery) {
	 	    	Thread.sleep(3000);
	 	    	String Records= ListRecord2.getText();
	 	    	System.out.println(Records);
	 	    	
	 	    }
	 	    System.out.println("+++++++The Patient Surgery History+++++++++++++++++++++++++++");
	}
	public void PatientSocialHistory() throws InterruptedException {
		SocialHistory.click();
		    List<WebElement> PTSocial = driver.findElements(By.xpath("//div[@id='socHis']/div/div[1]/div"));
		    System.out.println("Patinet Social history records: " + PTSocial.size());
		    for(WebElement ListRecord3 :PTSocial) {
		    	Thread.sleep(3000);
		    	String Records= ListRecord3.getText();
		    	System.out.println(Records);
		    	
		    }
		    System.out.println("+++++++The Patient Social History+++++++++++++++++++++++++++");
	}
	public void PatinetFamilyHistory() throws InterruptedException {
		FamilyHistory.click();
		    List<WebElement> PTFamilyHistr = driver.findElements(By.xpath("//div[@id='famHis']/div/div[1]/div"));
		    System.out.println("Patinet Family history records: " + PTFamilyHistr.size());
		    for(WebElement ListRecord4 :PTFamilyHistr) {
		    	Thread.sleep(3000);
		    	String Records= ListRecord4.getText();
		    	System.out.println(Records);
		    	
		    }
		    System.out.println("+++++++The Patient family History+++++++++++++++++++++++++++");
	}
//	public void TheAllergyFunction() throws InterruptedException {
//		Allergies.click(); 
//		Thread.sleep(3000);
//		List<WebElement> PTAllergy = driver.findElements(By.xpath("//div[@id='ALLERG']/div/div[2]/div/div[1]/div"));
//	
//	    System.out.println("Patinet Allergy history records: " + PTAllergy.size());
//	    for(WebElement ListOfAllergy :PTAllergy) {
//	    	Thread.sleep(3000);
//	    	String Records= ListOfAllergy.getText();
//	    	System.out.println(Records);
//	    }
//	    System.out.println("=================================Allergyes=================================");
//	}
//	
}