package tests;

import mods.BrowserMode;
import main.BaseSuite;
import org.junit.jupiter.api.Test;
import pages.TrainingPageSelenium;

import static org.assertj.core.api.Assertions.assertThat;

class KioskTest extends BaseSuite {
    @Override
    protected BrowserMode getMode() {
        return BrowserMode.KIOSK;
    }

    @Test
    void modalWindowTest() {
        TrainingPageSelenium page = new TrainingPageSelenium(driver);
        page.open();
        logger.info("Открылась страница тренажера работы с Selenium");

        page.openModal();
        logger.info("Открылось модальное окно");

        assertThat(page.isModalDisplayed()).isTrue();
        logger.info("Проверка открытия модального окна пройдена");
    }
}