package automationPractiseSetup;

import automationPractisePages.automationPractiseHomePage;
import automationPractisePages.automationPractiseLoginPage;
import automationPractisePages.automationPractiseSignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
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
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(priority = 1)
    public void navigateToHomepage(){
        objAutomationPractiseHomePage = new automationPractiseHomePage(driver);
        objAutomationPractiseHomePage.verifyPageHeader();
        objAutomationPractiseHomePage.verifyPageTitle();
        objAutomationPractiseHomePage.clickOnSignUp();
    }

    @Test(priority = 2)
    public void navigateToLoginPage(){
        objautomationPractiseLoginPage = new automationPractiseLoginPage(driver);
        objautomationPractiseLoginPage.checkPageTitle();
    }

    @Test(priority = 3)
    public void validWrongEmail() throws InterruptedException {
        objautomationPractiseLoginPage = new automationPractiseLoginPage(driver);
        objautomationPractiseLoginPage.clearEmailFieldText();
        objautomationPractiseLoginPage.typeEmailAddress("incorrectEmail.pl");
        objautomationPractiseLoginPage.clickRegisterButton();
        objautomationPractiseLoginPage.valWrongEmailAddress();
    }

    @Test(priority = 4)
    public void validCorrectEmail() throws InterruptedException {
        objautomationPractiseLoginPage = new automationPractiseLoginPage(driver);
        objautomationPractiseLoginPage.clearEmailFieldText();
        objautomationPractiseLoginPage.typeEmailAddress("jankowalski@email.com");
        objautomationPractiseLoginPage.valCorrectEmailAddress();
        objautomationPractiseLoginPage.clickRegisterButton();
    }

    @Test(priority = 5)
    public void navigateToSignUp(){
        objautomationPractiseSignUpPage = new automationPractiseSignUpPage(driver);
        objautomationPractiseSignUpPage.checkFormDisplayed();
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }

}
