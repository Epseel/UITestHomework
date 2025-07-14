package factory;

import exceptions.BrowserTypeSupportExceptions;
import mods.BrowserMode;
import settings.ChromeSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private final BrowserMode mode;

    public WebDriverFactory(BrowserMode mode) {
        this.mode = mode;
    }

    public WebDriver getDriver() {
        String browserName = System.getProperty("browser", "chrome").toLowerCase();

        if ("chrome".equals(browserName)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(new ChromeSettings(mode).settings());
        }

        throw new BrowserTypeSupportExceptions(browserName);
    }
}