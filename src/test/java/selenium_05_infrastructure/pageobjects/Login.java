package selenium_05_infrastructure.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium_04_waits.pageobjects.Base;

import static org.testng.AssertJUnit.assertTrue;

public class Login extends Base {

    By loginFormLocator = By.id("login");
    By usernameLocator  = By.id("username");
    By passwordLocator  = By.id("password");
    By submitButton     = By.cssSelector("button");
    By successMessageLocator = By.cssSelector(".flash.success");
    By failureMessageLocator = By.cssSelector(".flash.error");

    public Login(WebDriver driver) {
        super(driver);
        visit("http://the-internet.herokuapp.com/login");
        assertTrue("The login form is not present",
                isDisplayed(loginFormLocator));
    }

    public void with(String username, String password) {
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(submitButton);
    }

    public Boolean successMessagePresent() {
        isDisplayed(find(successMessageLocator), 1);
        return isDisplayed(successMessageLocator);
    }

    public Boolean failureMessagePresent() {
        isDisplayed(find(failureMessageLocator), 1);
        return isDisplayed(failureMessageLocator);
    }
}
