package automationPractisePages;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.beans.Visibility;

public class automationPractiseSignUpPage {

    WebDriver driver;
    WebDriverWait wait;
    String pageTitle = "";

    @FindBy(id="account-creation_form")
    WebElement formCreateAccount;

    public automationPractiseSignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
        PageFactory.initElements(driver, this);
    }

    public void checkFormDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(formCreateAccount));
        Assert.assertTrue(formCreateAccount.isDisplayed());
    }

}
