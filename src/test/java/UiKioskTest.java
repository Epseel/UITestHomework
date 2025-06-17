import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UiKioskTest {
    private static final Logger logger = LogManager.getLogger(UiKioskTest.class);
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        logger.info("Настраиваем Chrome в режиме киоска");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testModalWindow() {
        String testUrl = "https://otus.home.kartushin.su/training.html";
        logger.info("1. Открываем страницу: {}", testUrl);
        driver.get(testUrl);

        logger.info("2. Нажимаем кнопку открытия модального окна");
        WebElement openModalBtn = driver.findElement(By.id("openModalBtn"));
        openModalBtn.click();

        logger.info("3. Проверяем, что модальное окно отобразилось");
        WebElement modalWindow = driver.findElement(By.id("myModal"));
        Assertions.assertEquals("block", modalWindow.getCssValue("display"));
        logger.info("Тест успешно завершён!");
    }

    @AfterEach
    public void postcondition() {
        logger.info("Закрываем браузер");
        if (driver != null) {
            driver.quit();
        }
    }
}