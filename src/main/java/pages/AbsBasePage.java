package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage {
    protected WebDriver driver;
    protected final Logger logger = LogManager.getLogger(this.getClass());
    protected final String baseUrl = System.getProperty("base.url");

    public AbsBasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        logger.info("Открываем URL: {}", baseUrl);
        driver.get(baseUrl);
    }
}