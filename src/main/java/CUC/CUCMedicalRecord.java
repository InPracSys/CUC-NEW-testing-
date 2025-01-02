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

public class CUCMedicalRecord {
    WebDriver driver;

    // Declaration
    @FindBy(xpath = "//input[@id='UserName']")
    private WebElement reg_username;

    @FindBy(xpath = "//input[@id='Passwd']")
    private WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-block LoginBt']")
    private WebElement signuplink;

    @FindBy(xpath = "//div[@class='left_panel text-center']/div[2]")
    private WebElement medicalRecord;

    @FindBy(xpath = "//*[@id=\"HealthSummary\"]/div[1]/div[1]/h4/a/span")
    private WebElement diagnosis;
    @FindBy(xpath = "//*[@id=\"HealthSummary\"]/div[2]/div[1]/h4/a/span")
    private WebElement TreatmentsPlan;
    @FindBy(xpath = "//*[@id=\"HealthSummary\"]/div[3]/div[1]/h4/a/span")
    private WebElement Allergies;
    @FindBy(xpath = "//*[@id=\"HealthSummary\"]/div[4]/div[1]/h4/a/span")
    private WebElement ActivePrescription;

    public CUCMedicalRecord(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void UserName() {
        reg_username.sendKeys("TestBw");
    }

    public void Password1() {
        password.sendKeys("Test@1234");
    }

    public void clickLoginLink() {
        signuplink.click();
    }

    public void TheMedicalRecord() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        medicalRecord.click();
        diagnosis.click();
        Thread.sleep(1000);

        List<WebElement> medRecList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='MedRc']/li")));

        System.out.println("Number of items in the list: " + medRecList.size());

        for (WebElement item : medRecList) {
            System.out.println(item.getText());
        }
    }

    public void MedSummery() throws InterruptedException {
    	 diagnosis.click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	
    	WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='DIAGNOSIS']/div/table")));
    	
     
        List<WebElement> rows = table.findElements(By.xpath("//div[@id='DIAGNOSIS']/div/table/tbody/tr"));
        
        System.out.println("Number of rows: " + rows.size());
        List<WebElement> cols = table.findElements(By.xpath("//div[@id='DIAGNOSIS']/div/table/tbody[1]/tr[1]/td")); // Get columns from the first row
        System.out.println("Number of columns: " + cols.size());

        for (int r = 1; r <= rows.size(); r++) {
            for (int c = 1; c <= cols.size(); c++) {
            	
            	 try {
            		 Thread.sleep(2000);
                String value = table.findElement(By.xpath("//div[@id='DIAGNOSIS']/div/table/tbody[2]/tr["+ r +"]/td[" +c+ "]")).getText();
                Thread.sleep(3000);
                System.out.println("==> " + value);
            
            } catch (Exception e) {
                System.out.println("Element not found for row " + r + " and column " + c);
            }
          
            
            }
        }
        System.out.println("=============================Table===================================");
    }
    public void TreatMents() throws InterruptedException {
    
    	    TreatmentsPlan.click();
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //
    	    List<WebElement> TreatDescrip = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='TREATMENT']/div/p/ul/li")));
    	    Thread.sleep(4000);
    	    for (WebElement TreatData : TreatDescrip) {
    	        System.out.println(TreatData.getText());

    	    }
    		System.out.println("++++++++++++++++++++TreatmentData Dissplayed++++++++++++++++++++++++++++++++++");
    }
    public void allergies() throws InterruptedException {
    	Thread.sleep(5000);
    	Allergies.click();
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); 
    	List<WebElement> allergylist= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"spallergies\"]/span")));
        System.out.println("Number of allergy elements found: " + allergylist.size());       
    	for (WebElement AllergyList : allergylist) {
    		Thread.sleep(3000);
                	 System.out.println("+========>"+AllergyList.getText());
		} 
         		System.out.println("++++++++++++++++++++Allergies list Dissplayed++++++++++++++++++++++++++++++++++");
                }
    public void ActivePrescriptiondetails() throws InterruptedException {
    	Thread.sleep(5000);
    	ActivePrescription.click();
    
   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); 
   	List<WebElement> Presc= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MedicationDetail']")));
       System.out.println("Number of elements found: " + Presc.size());       
   	for (WebElement PrescList : Presc) {
   		Thread.sleep(3000);
               	 System.out.println("ActivePrescription is========>"+PrescList.getText());
					
				} 
//             WebElement ReFill= driver.findElement(By.xpath("//button[@class='ReqRefillBT pull-right']"));
//             ReFill.click();
               }
    }
    


