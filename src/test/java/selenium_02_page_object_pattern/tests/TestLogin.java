package selenium_02_page_object_pattern.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_02_page_object_pattern.dataproviders.CredentialsProvider;
import selenium_02_page_object_pattern.pageobjects.Login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestLogin {

    private WebDriver driver;
    private Login login;

    @BeforeClass
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
    public void whenLoggedInWithCorrectCredentials_thenSuccessVisible(){
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue( login.successMessagePresent());
    }

    /**
     * Fill the content of the test below
     */
    @Test
    public void whenLoggedInWithIncorrectCredentials_thenInvalidPasswordVisible() {
        login.with("tomsmith", "SuperSecretPasswod!");

        for (char ch: login.getErrorMessage().toCharArray()) {
            System.out.print((int)ch + ",");
        }
        String expected = "Your password is invalid!\n" + (char)215;
        System.out.println("");
        for (char ch: expected.toCharArray()) {
            System.out.print((int)ch + ",");
        }
        assertEquals(expected, login.getErrorMessage());
    }

    @Test(dataProvider = "credentials", dataProviderClass = CredentialsProvider.class)
    public void incorrectCredentialsLoginTest(String username, String password) {
        login.with(username, password);

        for (char ch: login.getErrorMessage().toCharArray()) {
            System.out.print((int)ch + ",");
        }
        String expected = "Your username is invalid!\n" + (char)215;
        System.out.println("");
        for (char ch: expected.toCharArray()) {
            System.out.print((int)ch + ",");
        }
        assertEquals(expected, login.getErrorMessage());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
