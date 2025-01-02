
package TUGPCABase;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//input[@id='txtUserName']")
    private WebElement username;

    @FindBy(xpath="//input[@id='txtPassword']")
    private WebElement pass;

    @FindBy(xpath="//button[@class='btn-block LoginBtn']")
    private WebElement logedIn;

    @FindBy(xpath="//div[@class='MainContainer']/div[2]/div/div[6]")
    private WebElement ClickClinic_I;

    @FindBy(xpath="//p-splitbutton[@id=\"SaveFilterSBtn\"]/div/button[1]/span")
    private WebElement MovetoElement;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername() {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("kumar");
    }

    public void enterPassword() {
        wait.until(ExpectedConditions.visibilityOf(pass));
        pass.sendKeys("Guess@123");
    }

    public void logInApplication() {
        wait.until(ExpectedConditions.elementToBeClickable(logedIn));
        logedIn.click();
    }

    public void clickOnClinical_I() {
        wait.until(ExpectedConditions.elementToBeClickable(ClickClinic_I));
        ClickClinic_I.click();
        System.out.println("Clinical_I logged In");
    }

    public void switchToIframe() {
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='zsFeedbackUser']")));
        driver.switchTo().frame(iframe);
        System.out.println("Switched to iframe");
    }

    public void movingaction() throws InterruptedException {
//        try {
//            // Wait until the element is visible
//            wait.until(ExpectedConditions.visibilityOf(MovetoElement));
//            System.out.println("Element is visible: " + MovetoElement.getText());
//
//            // Perform the click action
//            Actions a = new Actions(driver);
//            a.moveToElement(MovetoElement).click().build().perform();
//            System.out.println("Clicked on the element.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error occurred while performing action on the element.");
//        }
    	Thread.sleep(3000);
    	//MovetoElement.click();
    	WebElement filter=driver.findElement(By.xpath("//DIV[@id=\"div_ClinicalI\"]/div/div[2]/div/app-clinical-i-prostrate-cancer/form/div[2]/div[1]/div[1]/span"));
    	filter.click();
  }

}

