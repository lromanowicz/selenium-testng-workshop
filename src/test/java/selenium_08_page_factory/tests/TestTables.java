package selenium_08_page_factory.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_08_page_factory.pageobjects.Tables;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class TestTables extends Base {
    private Tables tables;

    @BeforeClass
    public void setUp() {
        tables = new Tables(driver);
    }

    @Test
    public void withoutHelpfulMarkupDuesAscending() {
        tables.sortDuesAscending();
        List<Double> duesValues = tables.getDuesValues();
        for (int counter = 0; counter < duesValues.size() - 1; counter++) {
            assertThat(duesValues.get(counter), is(lessThanOrEqualTo(duesValues.get(counter + 1))));
        }
    }

    @Test
    public void withoutHelpfulMarkupDuesDescending() {
        tables.sortDuesDescending();
        List<Double> duesValues = tables.getDuesValues();
        for (int counter = 0; counter < duesValues.size() - 1; counter++) {
            assertThat(duesValues.get(counter), is(greaterThanOrEqualTo(duesValues.get(counter + 1))));
        }
    }
}
