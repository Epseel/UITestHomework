package settings;

import mods.BrowserMode;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeSettings {
    private final BrowserMode mode;

    public ChromeSettings(BrowserMode mode) {
        this.mode = mode;
    }

    public ChromeOptions settings() {
        ChromeOptions options = new ChromeOptions();

        switch (mode) {
            case HEADLESS:
                options.addArguments("--headless");
                break;
            case KIOSK:
                options.addArguments("--kiosk");
                break;
            case FULLSCREEN:
                options.addArguments("--start-fullscreen");
                break;
        }

        return options;
    }
}