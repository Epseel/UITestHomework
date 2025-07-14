package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrainingPageSelenium extends AbsBasePage {
    private final By textInput = By.id("textInput");
    private final By modalButton = By.id("openModalBtn");
    private final By modalWindow = By.cssSelector(".modal-content");
    private final By nameInput = By.id("name");
    private final By emailInput = By.id("email");
    private final By submitButton = By.cssSelector("button[type='submit']");
    private final By messageBox = By.id("messageBox");

    public TrainingPageSelenium(WebDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        driver.findElement(textInput).sendKeys(text);
    }

    public String getEnteredText() {
        return driver.findElement(textInput).getAttribute("value");
    }

    public void openModal() {
        driver.findElement(modalButton).click();
    }

    public boolean isModalDisplayed() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(modalWindow))
                .isDisplayed();
    }

    public void submitForm(String name, String email) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(messageBox))
                .getText();
    }
}