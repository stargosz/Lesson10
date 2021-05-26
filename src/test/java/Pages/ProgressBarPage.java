package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage {

    WebDriver driver;

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#progressbar")
    WebElement progressBar;

    @FindBy(css = ".progress-label")
    WebElement progressLabel;

    public WebElement getProgressLabel() {
        return progressLabel;
    }

}
