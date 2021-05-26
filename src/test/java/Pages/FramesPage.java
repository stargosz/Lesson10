package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class FramesPage {

    private Logger logger = LoggerFactory.getLogger("FramesPage.class");
    WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "iframe[name='iframe1']")
    WebElement frame1;

    @FindBy(css = "iframe[name='iframe2']")
    WebElement frame2;

    @FindBy(css = "#inputFirstName3")
    WebElement firstNameInput;

    @FindBy(css = "#inputSurname3")
    WebElement surnameInput;

    @FindBy(css = ".btn.btn-primary")
    WebElement signInButton;

    @FindBy(css = "input#inputLogin")
    WebElement loginInput;

    @FindBy(css = "#inputPassword")
    WebElement passwordInput;

    @FindBy(css = "#inlineFormCustomSelectPref")
    WebElement continentsSelect;

    @FindBy(css = ".form-check-input")
    List<WebElement> yearOfExperienceRadios;

    @FindBy(css = ".nav-ite .dropdown-toggle")
    WebElement basicMenu;

    @FindBy(css = "#alerts-item")
    WebElement alertsMenuItem;

    public void clickBasicMenu(){
        basicMenu.click();
    }

    public WebElement getAlertsMenuItem(){
        return alertsMenuItem;
    }


    public WebElement getFrame1() {
        return frame1;
    }

    public void setFrame1(WebElement frame1) {
        this.frame1 = frame1;
    }

    public WebElement getFrame2() {
        return frame2;
    }

    public void setFrame2(WebElement frame2) {
        this.frame2 = frame2;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public void setFirstNameInput(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public WebElement getSurnameInput() {
        return surnameInput;
    }

    public void setSurnameInput(String surname) {
        surnameInput.sendKeys(surname);
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getLoginInput() {
        return loginInput;
    }

    public void setLoginInput(String login) {
        loginInput.sendKeys(login);
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(String passwd) {
        passwordInput.sendKeys(passwd);
    }

    public void setContinentsSelect(String continent) {
        Select select = new Select(continentsSelect);
        select.selectByVisibleText(continent);
    }

    public WebElement getContinentsSelect() {
        return continentsSelect;
    }

    public List<WebElement> getYearOfExperienceRadios() {
        return yearOfExperienceRadios;
    }

    public void clickRandomYearOfExperienceRadios() {
        Random rnd = new Random();
        yearOfExperienceRadios.get(rnd.nextInt(yearOfExperienceRadios.size())).click();


    }

    public boolean getSelectedRadioButton(){
        boolean isRadioButtonSelected = false;
        for( WebElement radioButton : yearOfExperienceRadios){
            if (radioButton.isSelected()){
                logger.debug("Selected radio button has value: " +radioButton.getAttribute("value"));
                isRadioButtonSelected = true;
                break;
            }
        }
        return isRadioButtonSelected;
    }
}
