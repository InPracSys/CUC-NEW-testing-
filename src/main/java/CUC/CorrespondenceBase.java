package CUC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorrespondenceBase {
	  WebDriver driver;
			// Declaration
					@FindBy(xpath="//input[@id='UserName']") private WebElement reg_username;
					@FindBy(xpath="//input[@id='Passwd']") private WebElement Password;
					@FindBy(xpath="//button[@class='btn btn-block LoginBt']") private WebElement SignInApp;
					@FindBy(xpath="//div[@class='left_panel text-center']/div[4]") private WebElement CorrespondanceDetails;
		            @FindBy(xpath="//ul[@id='MedRc']/li[6]") private WebElement MedicalHistory;  
		            @FindBy(xpath="//div[@id='MEDICAL']/div") private WebElement ListOfComponant;
		            @FindBy(xpath="//div[@id='MEDICAL']/div[2]/div/h4/a/span") private WebElement PastHistory;
		         
	 public CorrespondenceBase( WebDriver driver) {
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
	   public void CorrespandanceFunctinDetails() throws InterruptedException {
		   CorrespondanceDetails.click();
		
		   List<WebElement> CorresPondList = driver.findElements(By.xpath("//div[@class='Right_panel']/div[1]/div/form/div/div"));
		    System.out.println("Number of Correspondance records: " + CorresPondList.size());
		    for(WebElement ListRecord :CorresPondList) {
		    	Thread.sleep(1000);
		    	String Records= ListRecord.getText();
		    	System.out.println(Records);
		    	
		    }
		  WebElement OPenReport=driver.findElement(By.xpath("//form[@id='ClinReccom']/div/div[3]/div[2]"));
		  OPenReport.click();
		  System.out.println("Report is open");
		   
	       
		  
	   }
	   
}
