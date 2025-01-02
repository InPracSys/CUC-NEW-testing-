package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://azcucptportal.inpracsys.com/");
        driver.manage().window().maximize();

        // Create WebDriverWait instance with Duration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the username input to be present and interactable
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UserName"))).sendKeys("Testbw");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Passwd"))).sendKeys("Test@123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-block LoginBt']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-4 col-sm-4 point']"))).click();

        // Wait for the table to be present
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

        driver.quit();
    }
}


