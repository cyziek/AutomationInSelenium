package automationPractisePages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.Keys.TAB;

public class automationPractiseLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    String titleName = "Login - My Store"; //title of the page
    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    WebElement btnCreateAnAccount; // button 'Create An account'

    @FindBy(className = "form-error")
    WebElement iconInvalidEmail; //icon invalid email

    @FindBy(id = "create_account_error")
    WebElement alertInvalidEmail; //alert "1. Invalid email address"

    @FindBy(className = "form-ok")
    WebElement iconValidEmail; //icon correct email

    @FindBy(name = "email_create")
    WebElement txtFieldEmailAddress; //text Field 'Email address'


    public automationPractiseLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
        PageFactory.initElements(driver, this);
    }

    public void checkPageTitle() {
        wait.until(ExpectedConditions.titleIs(titleName));
        Assert.assertEquals(titleName, driver.getTitle());
    }
    public void clearEmailFieldText(){
        wait.until(ExpectedConditions.visibilityOf(txtFieldEmailAddress));
        txtFieldEmailAddress.clear();
    }

    public void typeEmailAddress(String email) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(txtFieldEmailAddress));
        txtFieldEmailAddress.sendKeys(email);
        txtFieldEmailAddress.sendKeys(Keys.TAB); //click outside the email text field
    }

    public void valWrongEmailAddress() {
        Assert.assertTrue(iconInvalidEmail.isDisplayed());
    }

    public void valCorrectEmailAddress() {
        wait.until(ExpectedConditions.visibilityOf(iconValidEmail));
        Assert.assertTrue(iconValidEmail.isDisplayed());
    }

    public void clickRegisterButton() {
        btnCreateAnAccount.click();
    }


}
