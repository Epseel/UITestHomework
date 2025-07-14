package tests;

import mods.BrowserMode;
import main.BaseSuite;
import org.junit.jupiter.api.Test;
import pages.TrainingPageSelenium;

import static org.assertj.core.api.Assertions.assertThat;

class FullscreenTest extends BaseSuite {
    @Override
    protected BrowserMode getMode() {
        return BrowserMode.FULLSCREEN;
    }

    @Test
    void formSubmissionTest() {
        TrainingPageSelenium page = new TrainingPageSelenium(driver);
        page.open();
        logger.info("Открылась страница тренажера работы с Selenium");

        String name = "Иван";
        String email = "test@example.com";
        page.submitForm(name, email);
        logger.info("В форму для имени введено значение: {}, для email введено значение: {}", name, email);

        String expectedMessage = String.format("Форма отправлена с именем: %s и email: %s", name, email);
        assertThat(page.getSuccessMessage()).isEqualTo(expectedMessage);
        logger.info("Проверка формы ввода пройдена");
    }
}