package Practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://azcucptportal.inpracsys.com/");
driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
Thread.sleep(3000);

driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("Testbw");
driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("Test@123");
driver.findElement(By.xpath("//button[@class='btn btn-block LoginBt']")).click();
driver.findElement(By.xpath("//div[@class='col-md-4 col-sm-4 point']")).click();


Thread.sleep(1000);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='currmedet1']")));
//WebElement table = driver.findElement(By.xpath("//table[@id='currmedet1']"));
int rows=driver.findElements(By.xpath("//table[@id='currmedet1']/tbody[2]/tr")).size();
System.out.println(rows);
int cols=driver.findElements(By.xpath("//table[@id='currmedet1']/tbody[2]/tr/td")).size();
System.out.println(cols);
// rows==> external loop
// cols==> internal loop
for (int r=1; r<=rows;r++) {
for (int c=1;c<=cols;c++) {
String value = driver.findElement(By.xpath("//div[@class='reqmoddiv']/table/tbody[2]/tr["+c+"]/td["+r+"]")).getText();
System.out.print("==>"+ value);
}
System.out.println();
}

	}

}
