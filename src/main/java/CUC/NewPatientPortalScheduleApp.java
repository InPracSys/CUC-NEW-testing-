package CUC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class NewPatientPortalScheduleApp {

		@FindBy(xpath="//input[@id='UserName']") private WebElement reg_username;
		@FindBy(xpath="//input[@id='Passwd']") private WebElement Password;
		@FindBy(xpath="//button[@class='btn btn-block LoginBt']") private WebElement signuplink;
		@FindBy(xpath="/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div/div[2]/div[1]") private WebElement Schedul_app;
		@FindBy(xpath="//select[@id='shduelvistwith']") private WebElement Visit_DDown;
		@FindBy(xpath="//select[@id='Locselect']") private WebElement Location;
		@FindBy(xpath="//select[@id='shduelvistwith']") private WebElement Location_Select;
		@FindBy(xpath="//select[@id='reasonselect']") private WebElement ReasonForVisit ;
		@FindBy(xpath="//textarea[@id='Appointnotes']") private WebElement TextWrite ;
		@FindBy(xpath="//a[@class='UpcomingAppointment_btncancel']") private WebElement CancelButton ;
	//	@FindBy(xpath="//button[@id='btnscheduleappointment']") private WebElement SaveButton ;
		
		public NewPatientPortalScheduleApp(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		public void UserName() {
			reg_username.sendKeys("TestBw");
		}
		
		
		public void Password1() {
			Password.sendKeys("Test@1234");
		}
		public void clickLoginLink() {
			signuplink.click();
		}

	    public void SchedulePatientAppointm() {
	    	Schedul_app.click();
	    }
	    public void Visitdropdown() {
	    	Visit_DDown.click();
	        Select select = new Select(Visit_DDown);

	         select.selectByVisibleText("CHRISTOPHER LODOWSKY");
		     
		     Visit_DDown.click();
		     System.out.println("dropdown is open");
	    }
		public void Locations() {
		        Select select2 = new Select(Location_Select);

		         select2.selectByIndex(3);
		         Location_Select.click();
			     System.out.println("Location is selected");
	}
		public void ReasonVisit() {
	        Select select3 = new Select(ReasonForVisit);

	         select3.selectByIndex(4);
	         ReasonForVisit.click();
		     System.out.println("Reason Selected");
		     Reporter.log("Reason Selected");
}

	  public void SelectDateFromCalendar(WebDriver driver, String date) throws InterruptedException {
	        
	        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datefrom']"));
	        datePicker.click();
	        Thread.sleep(2000);
	        System.out.println("click on textbox");
	        WebElement selectedDate = datePicker.findElement(By.xpath("//a[normalize-space()='25']"));
	        selectedDate.click();
	        
	        System.out.println("Selected date: " +date);
	        Reporter.log("Selected date: " );
		

	}

	  public void SelectToDateCalendar(WebDriver driver, String date1) {
	        
	        WebElement datePicker2 = driver.findElement(By.xpath("//input[@id='dateto']"));
	        datePicker2.click();
	        System.out.println("date to is selected");
	        datePicker2.sendKeys("09/09/2024");
	        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[2]")).click();
	 
	       
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	     //   WebElement selectedToDate = datePicker2.findElement(By.xpath("//*[@id="ui-datepicker-div"]/table/tbody/tr[4]/td[3]/a"));
	       // selectedToDate.click();
	        
	        System.out.println("Selected date: " );
	        Reporter.log("Selected date: " );
}
	 public void checkboxwensday(WebDriver driver) throws InterruptedException {
	    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	           WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-10']/table/tbody/tr[1]/td[3]")));
	   
	           checkbox.click();
	           Thread.sleep(2000);

	         WebElement Checkbox2=driver.findElement(By.xpath("//div[@class='col-md-10']/table/tbody/tr[2]/td[3]"));
	         if (!Checkbox2.isSelected()) {
	        	 Checkbox2.click();
	        	 System.out.println("Verified the checkboxes is clickable");
	    }
	    
	    }
 public void TextsentToClinic() {
	    	TextWrite.sendKeys("This is text message for the testing purpose");
	    	System.out.println("Text message is sent");
	    }
	    public void CancelButtonClick() throws InterruptedException {
	    	Thread.sleep(5000);
	    	CancelButton.click();
	    	
	    }
//	    public void SaveTheMessage() {
//	    	SaveButton.click();
//	    }
}