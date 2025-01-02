package TugPCATest;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import TUGPCABase.Dashboard;

public class DashBoardexe {
    WebDriver driver;
    Dashboard dashboard;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tugtest.riskassistapp.com");
        dashboard = new Dashboard(driver);
    }

    @Test
    public void executionDashboard() throws InterruptedException {
        dashboard.enterUsername();
        dashboard.enterPassword();
        dashboard.logInApplication();
        dashboard.clickOnClinical_I();
       // dashboard.switchToIframe();
        dashboard.movingaction();
        Thread.sleep(5000);
      
    }

//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
