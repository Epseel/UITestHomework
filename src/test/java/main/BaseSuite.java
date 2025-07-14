package main;

import mods.BrowserMode;
import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseSuite {
    protected WebDriver driver;
    protected final Logger logger = LogManager.getLogger(this.getClass());

    protected abstract BrowserMode getMode();

    @BeforeEach
    public void init() {
        driver = new WebDriverFactory(getMode()).getDriver();
        logger.info("Запущен {} mode", getMode());
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver закрыт");
        }
    }
}