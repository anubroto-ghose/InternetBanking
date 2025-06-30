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

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TransactionHistoryTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(TransactionHistoryTest.class);

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
    public void testFilterTransactionHistoryByDateRange() {
        // Test data setup
        String startDate = "2023-01-01";
        String endDate = "2023-01-31";
        String expectedTransactionId = "12345"; // Example transaction ID

        try {
            // Navigate to transaction history page
            driver.get("http://localhost:8080/transaction-history");
            logger.info("Navigated to transaction history page");

            // Set date range in filters
            WebElement startDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startDate")));
            startDateField.clear();
            startDateField.sendKeys(startDate);

            WebElement endDateField = driver.findElement(By.id("endDate"));
            endDateField.clear();
            endDateField.sendKeys(endDate);

            WebElement filterButton = driver.findElement(By.id("filterButton"));
            filterButton.click();

            // Verify filtered transactions
            WebElement transactionTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionTable")));
            assertTrue(transactionTable.isDisplayed(), "Transaction table should be visible");

            // Check for expected transaction within the filtered results
            boolean transactionFound = transactionTable.getText().contains(expectedTransactionId);
            assertTrue(transactionFound, "Expected transaction should be present in the filtered results");

            logger.info("Filter transaction history by date range test completed successfully");

        } catch (Exception e) {
            logger.error("Test failed with exception: " + e.getMessage());
            fail("Test execution failed: " + e.getMessage());
        }
    }
}