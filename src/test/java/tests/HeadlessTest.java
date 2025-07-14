package tests;

import mods.BrowserMode;
import main.BaseSuite;
import org.junit.jupiter.api.Test;
import pages.TrainingPageSelenium;

import static org.assertj.core.api.Assertions.assertThat;

class HeadlessTest extends BaseSuite {
    @Override
    protected BrowserMode getMode() {
        return BrowserMode.HEADLESS;
    }

    @Test
    void textInputTest() {
        TrainingPageSelenium page = new TrainingPageSelenium(driver);
        page.open();
        logger.info("Открылась страница тренажера работы с Selenium");

        String text = "ОТУС";
        page.enterText(text);
        logger.info("Введен текст: {}", text);

        assertThat(page.getEnteredText()).isEqualTo(text);
        logger.info("Проверка введенного текста пройдена");
    }
}