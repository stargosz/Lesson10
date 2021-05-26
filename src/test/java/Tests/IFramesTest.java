package Tests;

import Pages.FramesPage;
import TestBase.TestBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IFramesTest extends TestBase {
    private Logger logger = LoggerFactory.getLogger("IFramesTest.class");
    FramesPage framesPage = new FramesPage(getDriver());

    @ParameterizedTest
    @DisplayName("Open 'seleniumui.moderntester' web page")
    @Order(1)
    @CsvSource("https://seleniumui.moderntester.pl/iframes.php, Automation Pratice")
    public void shouldOpenWebPage(String url, String title) {
        getDriver().get(url);
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle, is(title));
        logger.debug("Web browser opened on: " + url);
    }

    @ParameterizedTest
    @DisplayName("Switch to first iFrame and enters first name into input")
    @Order(2)
    @ValueSource(strings = "Michaela")
    public void shouldEnterValidFirstName(String firstName) {
        getDriver().switchTo().frame(framesPage.getFrame1());
        framesPage.setFirstNameInput(firstName);
        assertThat(framesPage.getFirstNameInput().getAttribute("value"), is(firstName));
        logger.debug("First name set to: " + firstName);
    }

    @ParameterizedTest
    @DisplayName("Enters last name into input")
    @Order(3)
    @ValueSource(strings = "Walsh")
    public void shouldEnterValidSurname(String surname) {
        framesPage.setSurnameInput(surname);
        assertThat(framesPage.getSurnameInput().getAttribute("value"), is(surname));
        logger.debug("Surname set to: " + surname);
    }

    @Test
    @DisplayName("Clicks 'Sign in' button and switches to default content")
    @Order(4)
    public void shouldClickSignInButton() {
        framesPage.clickSignInButton();
        logger.debug("'Sign in' button clicked");
        getDriver().switchTo().defaultContent();
        logger.debug("Switched to default content");
    }

    @ParameterizedTest
    @Order(5)
    @DisplayName("Switch to second iFrame and enters 'Login'")
    @ValueSource(strings = "Login123")
    public void shouldEnterValidLogin(String login) {
        getDriver().switchTo().frame(framesPage.getFrame2());
        logger.debug("Switched to second iFrame");
        framesPage.setLoginInput(login);
        logger.debug("Login set up to: " + login);
        assertThat(framesPage.getLoginInput().getAttribute("value"), is(login));
    }

    @ParameterizedTest
    @Order(6)
    @DisplayName("Enters password into input")
    @ValueSource(strings = "Passwd123")
    public void shouldEnterValidPassword(String password) {
        framesPage.setPasswordInput(password);
        logger.debug("Password set up to: " + password);
        assertThat(framesPage.getPasswordInput().getAttribute("value"), is(password));
    }

    @ParameterizedTest
    @Order(7)
    @DisplayName("Selects continent from select element")
    @ValueSource(strings = "Europe")
    public void shouldSelectContinent(String continent) {
        framesPage.setContinentsSelect(continent);
        Select mySelect = new Select(framesPage.getContinentsSelect());
        WebElement option = mySelect.getFirstSelectedOption();
        logger.debug("Value selected on select element is: " + continent);
        assertThat(option.getText(), is(continent));
    }

    @Test
    @Order(8)
    @DisplayName("Selects random radio button ")
    public void shouldSelectRandomRadioButton() {
        framesPage.clickRandomYearOfExperienceRadios();
        assertThat(framesPage.getSelectedRadioButton(), is(true));
    }

    @Test
    @DisplayName("Clicks 'Sign in' button and switches to default content")
    @Order(9)
    public void shouldClickSignInButtonInSecondIframe() {
        framesPage.clickSignInButton();
        logger.debug("'Sign in' button clicked");
        getDriver().switchTo().defaultContent();
        logger.debug("Switched to default content");
    }

    @Test
    @DisplayName("Clicks 'Basic menu' button")
    @Order(10)
    public void shouldClickBasicMenu() {
        framesPage.clickBasicMenu();
        logger.debug("'Basic menu' button clicked");
        assertThat(framesPage.getAlertsMenuItem().isDisplayed(), is(true));
    }
}
