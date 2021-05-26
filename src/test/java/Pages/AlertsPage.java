package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    WebDriver driver;
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#delayed-alert")
    WebElement delayedAlertButton;

    @FindBy(css = "#delayed-alert-label")
    WebElement alertMessage;

    public void clickDelayedAlertButton() {
        delayedAlertButton.click();
    }

    public WebElement getAlertMessage() {
        return alertMessage;
    }
}
