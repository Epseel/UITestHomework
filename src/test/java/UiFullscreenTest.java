import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UiFullscreenTest {
    private static final Logger logger = LogManager.getLogger(UiFullscreenTest.class);
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        logger.info("Настраиваем Google Chrome в режиме полного экрана");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testFormSubmission() {
        String testUrl = "https://otus.home.kartushin.su/training.html";
        String testName = "Ivan Testov";
        String testEmail = "Test@gmail.com";
        String expectedMessage = String.format("Форма отправлена с именем: %s и email: %s", testName, testEmail);

        logger.info("1. Открываем страницу: {}", testUrl);
        driver.get(testUrl);

        logger.info("2. Заполняем форму следующими данными: имя={}, email={}", testName, testEmail);
        driver.findElement(By.id("name")).sendKeys(testName);
        driver.findElement(By.id("email")).sendKeys(testEmail);

        logger.info("3. Нажимаем кнопку 'Отправить'");
        driver.findElement(By.cssSelector("#sampleForm button[type='submit']")).click();

        logger.info("4. Проверяем сообщение об успешной отправке");
        WebElement messageBox = driver.findElement(By.id("messageBox"));
        String actualMessage = messageBox.getText();

        Assertions.assertEquals(expectedMessage, actualMessage, "Сообщение не соответствует ожидаемому формату");

        logger.info("Тест успешно завершён! : {}", actualMessage);

    }

    @AfterEach
    public void tearDown() {
        logger.info("Закрываем браузер");
        if (driver != null) {
            driver.quit();
        }
    }
}