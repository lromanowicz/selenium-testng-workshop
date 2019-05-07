package selenium_08_page_factory.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_08_page_factory.pageobjects.DynamicLoading;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestDynamicLoading extends Base {

    private DynamicLoading dynamicLoading;

    @BeforeClass
    public void setUp() {
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        assertThat(dynamicLoading.finishTextPresent(), equalTo(true));
    }

    @Test
    public void elementAppears() {
        dynamicLoading.loadExample("2");
        assertThat(dynamicLoading.finishTextPresent(), equalTo(true));
    }

}
