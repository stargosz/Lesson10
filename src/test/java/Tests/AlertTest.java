package Tests;

import Pages.AlertsPage;
import TestBase.TestBase;
import org.junit.jupiter.api.*;
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
public class AlertTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(AlertTest.class);
    AlertsPage alertsPage = new AlertsPage(getDriver());

    @ParameterizedTest
    @DisplayName("Open 'seleniumui.moderntester' web page")
    @Order(1)
    @CsvSource("https://seleniumui.moderntester.pl/alerts.php, Automation Pratice")
    public void shouldOpenWebPage(String url, String title) {
        getDriver().get(url);
        String actualTitle = getDriver().getTitle();
        logger.debug("Web browser opened on: " + url);
        assertThat(actualTitle, is(title));
    }

    @ParameterizedTest
    @Order(2)
    @ValueSource(strings = "OK button pressed")
    public void shouldAcceptTheAlert(String expectedMessage) {
        alertsPage.clickDelayedAlertButton();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        logger.debug("Wait set up for 15 second, waiting until alert is present");
        assertThat(alertsPage.getAlertMessage().getText(), is(expectedMessage));
    }
}
