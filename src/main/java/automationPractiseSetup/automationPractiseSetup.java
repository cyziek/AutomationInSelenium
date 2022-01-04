package automationPractiseSetup;

import automationPractisePages.automationPractiseHomePage;
import automationPractisePages.automationPractiseLoginPage;
import automationPractisePages.automationPractiseSignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class automationPractiseSetup {
//    String driverPath = "D:\\ChromeDriver\\chromedriver.exe";
    WebDriver driver;

    automationPractiseHomePage objAutomationPractiseHomePage;
    automationPractiseLoginPage objautomationPractiseLoginPage;
    automationPractiseSignUpPage objautomationPractiseSignUpPage;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void navigateToHomepage(){
        objAutomationPractiseHomePage = new automationPractiseHomePage(driver);
        objAutomationPractiseHomePage.verifyPageTitle();
        objAutomationPractiseHomePage.verifyPageTitle();
        objAutomationPractiseHomePage.clickOnSignUp();
    }

    @Test
    public void navigateToLoginPage(){

    }

}
