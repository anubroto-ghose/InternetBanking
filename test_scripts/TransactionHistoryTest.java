/**
 * Test Case ID: TC_TransactionHistory_001
 * Generated from Jira Ticket: BANK-3065
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:26:29
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class TransactionHistoryTest {

    private WebDriver driver;

    @Mock
    private AccountService accountService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TokenService tokenService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        // Mocking the account service response
        User user = new User();
        user.setId(1);
        user.setUsername("testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(user);
        when(accountService.getTransactionHistory(user.getId())).thenReturn(getMockTransactionHistory());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testViewTransactionHistory() {
        driver.get("http://localhost:8080/transaction-history");

        List<WebElement> logs = driver.findElements(By.className("conversion-log"));
        assertFalse(logs.isEmpty(), "Transaction logs should not be empty");

        for (WebElement log : logs) {
            String inrAmount = log.findElement(By.className("inr-amount")).getText();
            String usdAmount = log.findElement(By.className("usd-amount")).getText();
            String exchangeRate = log.findElement(By.className("exchange-rate")).getText();
            String timestamp = log.findElement(By.className("timestamp")).getText();

            assertNotNull(inrAmount, "INR amount should not be null");
            assertNotNull(usdAmount, "USD amount should not be null");
            assertNotNull(exchangeRate, "Exchange rate should not be null");
            assertNotNull(timestamp, "Timestamp should not be null");
        }
    }

    private List<Transaction> getMockTransactionHistory() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1000, 12.5, 80.0, "2023-01-01T10:00:00"));
        transactions.add(new Transaction(2000, 25.0, 80.0, "2023-01-02T11:00:00"));
        return transactions;
    }
}