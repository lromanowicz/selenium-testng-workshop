package selenium_05_infrastructure.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_05_infrastructure.pageobjects.Login;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class TestLogin extends Base {

    private Login login;

    @BeforeClass
    public void setUp() {
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue("success message not present",
                login.successMessagePresent());
    }

    @Test
    public void failed() {
        login.with("tomsmith", "bad password");
        assertTrue("failure message wasn't present after providing bogus credentials",
                login.failureMessagePresent());
        assertFalse("success message was present after providing bogus credentials",
                login.successMessagePresent());
    }

}
