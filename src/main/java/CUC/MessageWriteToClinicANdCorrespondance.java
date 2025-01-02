package CUC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MessageWriteToClinicANdCorrespondance {
	                              //TestExcecuation = Correspondance Test
	  WebDriver driver;
			// Declaration
					@FindBy(xpath="//input[@id='UserName']") private WebElement reg_username;
					@FindBy(xpath="//input[@id='Passwd']") private WebElement Password;
					@FindBy(xpath="//button[@class='btn btn-block LoginBt']") private WebElement SignInApp;
					@FindBy(xpath="//button[@class='Home_Bottom_button footbt']") private WebElement MessageButton;
					@FindBy(xpath="//div[@id='fontb']/div[3]/div/div[2]/input") private WebElement Subject;
					@FindBy(xpath="//select[@id='msgregard']") private WebElement Drop_downClick;
					@FindBy(xpath="//textarea[@id=\"msgtextarea\"]") private WebElement WriteTextMessage;//button[@class='message_panel_btton']
		            @FindBy(xpath="//button[@class='message_panel_btton']") private WebElement SentMessage;
		            @FindBy(xpath="//*[@id=\"messagemodel\"]/div/div[1]/div[2]/a") private WebElement closeTheWindows;
		            
	 public MessageWriteToClinicANdCorrespondance( WebDriver driver) {
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
	   public void Messagebuttonclick() {
		   MessageButton.click();
		   
	   }
	   public void SubjectSent() throws InterruptedException {
		   Thread.sleep(2000);
		   Subject.sendKeys("Test Subject");
		   Drop_downClick.click();
	        Select select = new Select(Drop_downClick);
	        select.selectByIndex(3);

		     
	         Drop_downClick.click();
		     System.out.println("dropdown is open");
	   }
	   public void TextwriteSentMessage() throws InterruptedException {
		   WriteTextMessage.sendKeys("This is text message for testing purpose");
		  // SentMessage.click();
		
	   }
	   public void CloseThePopup() throws InterruptedException {
		   Thread.sleep(5000);
		   closeTheWindows.click();
	   }
}
