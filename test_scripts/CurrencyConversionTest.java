import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(SpringExtension.class)
@SpringBootTest
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
    public void testCurrencyConversionWithDecimalPrecision() {
        // Test data setup
        String inputAmount = "1234.56";
        String expectedConvertedAmount = "15.56"; // Expected USD amount for the test

        try {
            // Navigate to currency conversion page
            driver.get("http://localhost:8080/currency-conversion");
            logger.info("Navigated to currency conversion page");

            // Wait for and interact with currency input field
            WebElement inrField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inrAmount")));
            inrField.clear();
            inrField.sendKeys(inputAmount);

            // Trigger conversion
            WebElement convertButton = driver.findElement(By.id("convertButton"));
            convertButton.click();

            // Wait for result and verify precision
            WebElement resultField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usdAmount")));
            String actualConvertedAmount = resultField.getText();

            assertEquals(expectedConvertedAmount, actualConvertedAmount, "Converted amount should match expected value");
            logger.info("Currency conversion test completed successfully");

        } catch (Exception e) {
            logger.error("Test failed with exception: " + e.getMessage());
            fail("Test execution failed: " + e.getMessage());
        }
    }
}