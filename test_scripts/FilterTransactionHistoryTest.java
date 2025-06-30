package com.example.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.MockBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.service.UserService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class FilterTransactionHistoryTest {

    @Autowired
    private UserService userService;
    @Autowired
    private WebDriver webDriver;
    private WebDriverWait wait;

    @Test
    public void testFilterTransactionHistoryByDateRange() {
        // Test setup
        String fromDate = "2022-01-01";
        String toDate = "2022-06-30";

        webDriver.get("http://localhost:8080/transaction-history");

        // Set date range in filters
        webDriver.findElement(By.id("fromDateInput")).sendKeys(fromDate);
        webDriver.findElement(By.id("toDateInput")).sendKeys(toDate);
        webDriver.findElement(By.id("filterButton")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionTable")));

        // Check if transaction history data is filtered
        assertTrue(webDriver.findElements(By.cssSelector("tr.transaction-entry")).stream()
            .allMatch(element -> {
                String transactionDate = element.findElement(By.cssSelector("td.transaction-date")).getText();
                return fromDate.compareTo(transactionDate) <= 0 && toDate.compareTo(transactionDate) >= 0;
            }), "Transaction history data should be filtered by date range");
    }
}