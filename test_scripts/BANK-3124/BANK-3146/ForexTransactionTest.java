/**
 * Test Case ID: TC_Forex_001
 * Generated from Jira Ticket: BANK-3146
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:42:51
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ForexTransactionTest {

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testDisplayOngoingForexTransactions() {
        // Mock the necessary services
        when(tokenService.isValidToken(anyString())).thenReturn(true);
        when(accountService.getOngoingForexTransactions(anyLong())).thenReturn(getMockedTransactions());

        // Simulate user login
        driver.get("http://localhost:8080/login");
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        usernameInput.sendKeys("testuser");
        passwordInput.sendKeys("testpassword");
        driver.findElement(By.id("loginButton")).click();

        // Navigate to forex transactions section
        driver.get("http://localhost:8080/forex-transactions");

        // Verify ongoing transactions display
        WebElement transactionsSection = driver.findElement(By.id("transactionsSection"));
        assertNotNull(transactionsSection);
        assertTrue(transactionsSection.getText().contains("Pending"), "No pending transactions displayed");

        // Cleanup
        driver.quit();
    }

    private List<ForexTransaction> getMockedTransactions() {
        List<ForexTransaction> transactions = new ArrayList<>();
        transactions.add(new ForexTransaction(1L, "USD/EUR", 1000.0, "Pending"));
        transactions.add(new ForexTransaction(2L, "GBP/USD", 1500.0, "Pending"));
        return transactions;
    }
}