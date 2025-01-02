package TUGPCABase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
	
	    WebDriver driver;

	    // Declaration
	    @FindBy(xpath = "//input[@id='txtUserName']")
	    private WebElement reg_username;

	    @FindBy(xpath = "//input[@id='txtPassword']")
	    private WebElement password;

	    @FindBy(xpath = "//div[@class='form-group']/select[@name='SearchType']")
	    private WebElement clicklogin;

	    public LogIn(WebDriver driver) {
	    	this.driver=driver;
	    	PageFactory.initElements(driver, this);
	    }
	    public void loginapplication() {
	    	reg_username.sendKeys("kumar");
	    	password.sendKeys("");
	    	clicklogin.click();
	    }
}
