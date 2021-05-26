package Tests;

import Pages.ProgressBarPage;
import TestBase.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProgressBarTest extends TestBase {
    private Logger logger = LoggerFactory.getLogger(ProgressBarTest.class);
    ProgressBarPage progressBarPage = new ProgressBarPage(getDriver());


    @ParameterizedTest
    @DisplayName("Open 'seleniumui.moderntester' web page")
    @Order(1)
    @CsvSource("https://seleniumui.moderntester.pl/progressbar.php, Automation Pratice")
    public void shouldOpenWebPage(String url, String title) {
        getDriver().get(url);
        String actualTitle = getDriver().getTitle();
        logger.debug("Web browser opened on: " + url);
        assertThat(actualTitle, is(title));
    }

    @ParameterizedTest
    @Order(2)
    @ValueSource(strings = "Complete!")
    public void shouldWaitForTextToBePresent(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.textToBePresentInElement(progressBarPage.getProgressLabel(), expectedMessage));
        logger.debug("Wait for progress bar message to be 'Complete!'");
        assertThat(progressBarPage.getProgressLabel().getText(), is(expectedMessage));
    }
}
