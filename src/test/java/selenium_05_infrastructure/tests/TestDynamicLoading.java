package selenium_05_infrastructure.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_05_infrastructure.pageobjects.DynamicLoading;

import static org.testng.AssertJUnit.assertTrue;

public class TestDynamicLoading extends Base {

    private DynamicLoading dynamicLoading;

    @BeforeClass
    public void setUp() {
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        assertTrue("finish text didn't display after loading",
                dynamicLoading.isFinishTextDisplayed());
    }

    @Test
    public void elementAppears() {
        dynamicLoading.loadExample("2");
        assertTrue("finish text didn't render after loading",
                dynamicLoading.isFinishTextTextPresent());
    }
}
