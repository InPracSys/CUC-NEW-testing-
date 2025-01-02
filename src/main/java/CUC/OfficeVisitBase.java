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

public class OfficeVisitBase {

	  WebDriver driver;
		// Declaration
				@FindBy(xpath="//input[@id='UserName']") private WebElement reg_username;
				@FindBy(xpath="//input[@id='Passwd']") private WebElement Password;
				@FindBy(xpath="//button[@class='btn btn-block LoginBt']") private WebElement SignInApp;
				@FindBy(xpath = "//div[@class='left_panel text-center']/div[2]") private WebElement medicalRecord;
	            @FindBy(xpath="//li[@id='ofclink']") private WebElement OfficeVisit;  
	            @FindBy(xpath="//div[@id=\"visits\"]/div/div[1]/div[2]/div/a[2]/img") private WebElement MessageSent;
   public OfficeVisitBase( WebDriver driver) {
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
	public void OfficeVisitClick() throws InterruptedException {
		OfficeVisit.click();
//		Thread.sleep(4000);
//		WebElement Button=driver.findElement(By.xpath("//div[@id='OFFICE']/div/div[1]/h4/a/span"));
//		Button.click();
	}
	 public void TheMedicalRecord() throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	        List<WebElement> medRecList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='visits']/div/div")));
	        System.out.println("Number of items in the list: " + medRecList.size());
             Thread.sleep(2000);
	
	        for (WebElement item : medRecList) {
	            System.out.println(item.getText());
	        }
	        WebElement clickOnMessage=driver.findElement(By.xpath("//div[@id=\"visits\"]/div/div[1]/div[2]/div/a[1]/img"));
	    	clickOnMessage.click();
	    	System.out.println("===============================================================================================================");
	 }
	public void MyVisitDetails() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        List<WebElement> VisitData = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='mychart']/div/div[2]/div[2]/table")));
        System.out.println("Number of items in the list: " + VisitData.size());
 
        for (WebElement item : VisitData) {
            System.out.println(item.getText());
        }
        System.out.println("The output is ======>");
        Thread.sleep(5000);
        WebElement CloseWindow=driver.findElement(By.xpath("//div[@id=\"mychart\"]/div/div[1]/div[2]/a"));
        CloseWindow.click();
	}
	public void SentTheMessage() {
		MessageSent.click();
	}

	 }
