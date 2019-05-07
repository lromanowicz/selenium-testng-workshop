package selenium_01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("win") >= 0) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        }

        driver = new ChromeDriver();
    }

    @Test
    public void whenLoggedInWithCorrectCredentials_thenSuccessVisible() {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();
        WebElement message = driver.findElement(By.cssSelector(".flash.success"));
        assertTrue( message.isDisplayed() );
        assertTrue( message.getText().contains("You logged into a secure area!") );
    }

    /**
     * Fill the content of the test below
     */
    @Test
    public void whenLoggedInWithIncorrectCredentials_thenInvalidPasswordVisible() {
    }

    /**
     * Additional tasks and questions
     *  - How this code could be optimized
     *  - Closing driver after each test
     */

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
