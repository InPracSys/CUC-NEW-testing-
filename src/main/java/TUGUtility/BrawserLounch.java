package TUGUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrawserLounch {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://tugtest.riskassistapp.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='txtUserName']")).sendKeys("kumar");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Guess@123");

        driver.findElement(By.xpath("//button[@class='btn-block LoginBtn']")).click();
        
        // Adding WebDriverWait for element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for the element to be clickable
        WebElement clinicalElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='MainContainer']/div[2]/div/div[6]")));
        clinicalElement.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='zsFeedbackUser']")));
            driver.switchTo().frame(iframe);
            System.out.println("Switched to iframe");
        } catch (Exception e) {
            System.out.println("Failed to switch to iframe: " + e.getMessage());
            throw e;
        }
        WebElement PCAS = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='PageHeader']/div[1]/ul/li[3]")));
        
       Actions ak= new Actions(driver);
       ak.click();
        
        System.out.println("Clicked on PCA element");
        
        // Optional: Close the browser
        // driver.quit();
    }



}
