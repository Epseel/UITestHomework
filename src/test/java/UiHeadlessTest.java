import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UiHeadlessTest {
    private static final Logger logger = LogManager.getLogger(UiHeadlessTest.class);
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        logger.info("Настраиваем Google Chrome в headless режиме");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testTextInput() {
        String testUrl = "https://otus.home.kartushin.su/training.html";
        String inputText = "ОТУС";

        logger.info("1. Открываем страницу: {}", testUrl);
        driver.get(testUrl);

        logger.info("2. Вводим текст: {}", inputText);
        WebElement inputField = driver.findElement(By.id("textInput"));
        inputField.sendKeys(inputText);

        logger.info("3. Сверяем текст в поле");
        Assertions.assertEquals(inputText, inputField.getAttribute("value"));

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