package automationPractisePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
public class automationPractiseLoginPage {

    WebDriver driver;

    @FindBy (xpath="//*[@id=\"SubmitCreate\"]/span")
    WebElement btnCreateAnAccount;

    public automationPractiseLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkPageTitle(){
        assertEquals("Login - My Store", driver.getTitle());
    }
    

}
