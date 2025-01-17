package selenium_10_image_comparison.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import selenium_10_image_comparison.pageobjects.Checkboxes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static selenium_10_image_comparison.ImageComparison.compareImages;

public class ImageCompareTest extends Base {
    private Checkboxes checkboxes;

    @BeforeClass
    public void setUp() {
        checkboxes = new Checkboxes(driver);
    }

    @Test
    public void imagesShouldBeDifferent() {
        Screenshot scrShot = new AShot().takeScreenshot(driver);
        checkboxes.clickFirstCheckbox();
        Screenshot newScrShot = new AShot().takeScreenshot(driver);
        assertTrue(compareImages(scrShot, newScrShot));
    }

    @Test
    public void imagesShouldNotBeDifferent() {
        Screenshot scrShot = new AShot().takeScreenshot(driver);
        Screenshot newScrShot = new AShot().takeScreenshot(driver);

        assertFalse(compareImages(scrShot, newScrShot));
    }

    @Test
    public void screenshotShouldBeTheSameAsBaseline() throws IOException {
        Screenshot actual = new AShot().takeScreenshot(driver);
        BufferedImage actualImage = actual.getImage();
        BufferedImage expectedImage = ImageIO.read(new File("src/test/resources/baseline.png"));

        assertFalse(compareImages(expectedImage, actualImage));
    }
}
