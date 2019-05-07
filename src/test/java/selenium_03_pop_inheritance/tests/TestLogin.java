package selenium_03_pop_inheritance.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium_03_pop_inheritance.pageobjects.Login;

import static org.testng.AssertJUnit.assertTrue;

public class TestLogin {

    private WebDriver driver;
    private Login login;

    @BeforeMethod
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("win") >= 0) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        }

        driver = new ChromeDriver();
        login = new Login(driver);
    }

    @Test
    public void whenLoggedInWithCorrectCredentials_thenSuccessVisible() {
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue("success message not present",
                login.successMessagePresent());
    }

    /**
     * Fill the content of the test below
     */
    @Test
    public void whenLoggedInWithIncorrectCredentials_thenInvalidPasswordVisible() {
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
