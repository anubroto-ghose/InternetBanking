import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
public class CurrencyConversionTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionTest.class);

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.info("WebDriver initialized successfully");
    }

    @AfterEach  
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed successfully");
        }
    }

    @Test
    public void testCurrencyConversionZeroInput() {
        try {
            // Input zero amount in INR
            double inrAmount = 0.0;

            // Trigger the currency conversion
            double usdAmount = CurrencyConverter.convertINRtoUSD(inrAmount);

            // Verify the converted amount in USD is also zero
            assertEquals(0.0, usdAmount, 0.0001, "USD amount should be zero for zero input INR");

            logger.info("Currency conversion test completed successfully");

        } catch (Exception e) {
            logger.error("Test failed with exception: " + e.getMessage());
            fail("Test execution failed: " + e.getMessage());
        }
    }
}