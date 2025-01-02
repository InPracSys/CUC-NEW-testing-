package CUC;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestResultBase {

	  WebDriver driver;
		// Declaration
				@FindBy(xpath="//input[@id='UserName']") private WebElement reg_username;
				@FindBy(xpath="//input[@id='Passwd']") private WebElement Password;
				@FindBy(xpath="//button[@class='btn btn-block LoginBt']") private WebElement SignInApp;
				@FindBy(xpath = "//div[@class='left_panel text-center']/div[2]") private WebElement medicalRecord;
				@FindBy(xpath = "//ul[@id='MedRc']/li[3]") private WebElement TestResults;
	            @FindBy(xpath = "//ul[@id='MedRc']/li[4]") private WebElement OfficeReporT;  
	            @FindBy(xpath = "//textarea[@id=\"requesttxtarea\"]") private WebElement UpdateText; 
	            @FindBy(xpath = "//ul[@id='MedRc']/li[5]") private WebElement Medication; 
	            @FindBy(xpath = "//div[@id='MEDICAT']/div[1]/div[1]/h4/a/span") private WebElement CurrentMed;
	            @FindBy(xpath = "//div[@id='MEDICAT']/div[2]/div[1]/h4/a/span") private WebElement InActiveMed;
	            
public TestResultBase( WebDriver driver) {
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
	public void TheTestResultWindow() {
		TestResults.click();
	}
	public void TestResultDetailsList() throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='tresult']/div")));

	    // Get the rows and columns
		  Thread.sleep(2000);
	    List<WebElement> row1 = table.findElements(By.xpath("//*[@id=\"tresult\"]/div/table/tbody/tr"));
	    System.out.println("Number of rows: " + row1.size());
	    Thread.sleep(3000);
	    List<WebElement> colm = table.findElements(By.xpath("//div[@id='tresult']/div/table/tbody/tr[1]/td")); // Get columns from the first row
	    System.out.println("Number of columns: " + colm.size());
          Thread.sleep(2000);
	    // Iterate through rows and columns
	    for (int r = 1; r <= row1.size(); r++) {
	        for (int c = 1; c <= colm.size(); c++) {
	            String value = table.findElement(By.xpath("//div[@id='tresult']/div/table/tbody/tr[" + r + "]/td[" + c + "]")).getText();
	            System.out.print("==> " + value);
	        }
	        System.out.println();
	    }  
	    }
	public void OfficeReportdetails() throws InterruptedException {
		OfficeReporT.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ReportList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='OfficeR']/div/div[1]/div")));
		 Thread.sleep(3000);
		    List<WebElement> Lists = ReportList.findElements(By.xpath("//div[@id='OfficeR']/div/div[1]/div")); // Get columns from the first row
		    System.out.println("Number of columns: " + Lists.size());
	       //Open the Report
		  WebElement OpenReport=driver.findElement(By.xpath("//div[@id='OfficeReportsBody']/div[1]/div[2]/span"));
		  OpenReport.click();
		  Thread.sleep(5000);
		  //Windows Close 
		  WebElement CloseTheWindow=driver.findElement(By.xpath("//*[@id=\"ShowPdfModal\"]/div/div[1]/div[2]/a"));
		  CloseTheWindow.click();
		  System.out.println("Window closed");
		  //Request To Update 
		  Thread.sleep(3000);
		  WebElement RequiestUpdate=driver.findElement(By.xpath("//*[@id=\"OfficeR\"]/div/div[2]/button[2]"));
		  RequiestUpdate.click();
		  Thread.sleep(3000);
		  
		  UpdateText.sendKeys("Test Message");
		  
		  //Save Message
//		  WebElement Save=driver.findElement(By.xpath("//button[@id='btnsendrequestmed']"));
//		  Save.click();
		  WebElement CancelMessage=driver.findElement(By.xpath("//a[@id='reqmodclose']"));
		  CancelMessage.click();
		 }
	public void Medication() throws InterruptedException {
		Medication.click();
//		Thread.sleep(2000);
//		CurrentMed.click();
		System.out.println("Current Medicine");
		Thread.sleep(2000);
		InActiveMed.click();
		System.out.println("InActive Medicine");
	}
	
} 
