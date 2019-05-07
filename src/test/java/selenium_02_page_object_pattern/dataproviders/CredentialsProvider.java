package selenium_02_page_object_pattern.dataproviders;

import org.testng.annotations.DataProvider;

public class CredentialsProvider {

    @DataProvider
    public Object[][] credentials() {
        return new Object[][] {
                {"Bad_Username", "Bad_Password"},
                {"Another_Bad_Username", "Another_Bad_Password"}
        };
    }
}
