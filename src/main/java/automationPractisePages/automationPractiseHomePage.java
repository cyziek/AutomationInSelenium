package automationPractisePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class automationPractiseHomePage {

    WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement PageHeader;

    @FindBy(css ="a[title='Log in to your customer account']")
    WebElement SignInButton;

    public automationPractiseHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyPageTitle() {
        assertEquals("My Store", driver.getTitle());
    }

    public void verifyPageHeader() {
        String getPageHeader = PageHeader.getText();
        assertEquals("Automation Practice Website", getPageHeader);
    }

    public void clickOnSignUp(){
        SignInButton.click();
    }
}