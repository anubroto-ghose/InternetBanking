import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureTestWebDriver;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureTestWebDriver
public class TransactionHistoryFilterTest {

    @Autowired
    private WebDriver driver;

    private WebDriverWait wait;

    @BeforeEach
    public void setup() {
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost:8080/transaction-history");
    }

    @Test
    public void testFilterTransactionHistoryByDateRange() {
        try {
            // Set date range
            WebElement startDateInput = wait.until(elementToBeClickable(By.id("startDate")));
            WebElement endDateInput = wait.until(elementToBeClickable(By.id("endDate")));
            startDateInput.sendKeys("2023-01-01");
            endDateInput.sendKeys("2023-01-31");

            // Click on filter button
            WebElement filterButton = driver.findElement(By.id("filterButton"));
            filterButton.click();

            // Wait for results to load
            wait.until(visibilityOfElementLocated(By.id("transactionResults")));

            // Validate the results
            WebElement resultsContainer = driver.findElement(By.id("transactionResults"));
            assertNotNull(resultsContainer, "Transaction results should be displayed");
            assertTrue(resultsContainer.getText().contains("Transaction Date: 2023-01-15"), "Should contain transactions within the date range");
            assertFalse(resultsContainer.getText().contains("Transaction Date: 2023-02-01"), "Should not contain transactions outside the date range");

        } catch (Exception e) {
            fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}