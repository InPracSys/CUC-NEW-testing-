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

public class RefillRequiest {
  WebDriver driver;
	// Declaration
			@FindBy(xpath="//input[@id='UserName']") private WebElement reg_username;
			@FindBy(xpath="//input[@id='Passwd']") private WebElement Password;
			@FindBy(xpath="//button[@class='btn btn-block LoginBt']") private WebElement SignInApp;
            @FindBy(xpath="//div[@class='col-md-4 col-sm-4 point']") private WebElement RefillRequest;
            @FindBy(xpath="//*[@id=\"medicationrefille\"]/tr[2]/td[6]/input") private WebElement Checkbox;
    		@FindBy(xpath="//textarea[@id='refilnotes']") private WebElement WriteText;
    		@FindBy(xpath="//*[@id=\"refillmod\"]/div/div[1]/div[2]/a") private WebElement CloseWindow;
    		@FindBy(xpath="//textarea[@id='refilnotes']") private WebElement ttWriteText;
    		
    	
public RefillRequiest( WebDriver driver) {
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

public void refillinkclick() {
	RefillRequest.click();
	System.out.println("Click on the Refill");
}
public void tables() throws InterruptedException {
	Thread.sleep(1000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='currmedet1']")));

    // Get the rows and columns
    List<WebElement> rows = table.findElements(By.xpath(".//tbody[2]/tr"));
    System.out.println("Number of rows: " + rows.size());
    List<WebElement> cols = table.findElements(By.xpath(".//tbody[2]/tr[1]/td")); // Get columns from the first row
    System.out.println("Number of columns: " + cols.size());

    // Iterate through rows and columns
    for (int r = 1; r <= rows.size(); r++) {
        for (int c = 1; c <= cols.size(); c++) {
            String value = table.findElement(By.xpath(".//tbody[2]/tr[" + r + "]/td[" + c + "]")).getText();
            System.out.print("==> " + value);
        }
        System.out.println();
    }
	} 

public void TableCheckBox() {
    Checkbox.click();
}
public void WriteThetext() {
	WriteText.click();
	WriteText.sendKeys("This is the text Message from Tester");
	System.out.println("Text is sending to clinic");
}
public void closedtheWindows() throws InterruptedException {
	Thread.sleep(8000);
	CloseWindow.click();
	System.out.println("Close the windows");
}
}