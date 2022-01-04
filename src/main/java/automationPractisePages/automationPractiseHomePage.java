package automationPractisePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class automationPractiseHomePage {

    WebDriver driver;
    WebDriverWait wait;
    String pageTitle = "My Store";
    @FindBy(xpath = "//h1")
    WebElement PageHeader;

    @FindBy(css ="a[title='Log in to your customer account']")
    WebElement SignInButton;

    public automationPractiseHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 7);
    }

    public void verifyPageTitle() {
        wait.until(ExpectedConditions.titleIs(pageTitle));
        assertEquals(pageTitle, driver.getTitle());
    }

    public void verifyPageHeader() {
        String getPageHeader = PageHeader.getText();
        assertEquals("Automation Practice Website", getPageHeader);
    }

    public void clickOnSignUp(){
        SignInButton.click();
    }
}