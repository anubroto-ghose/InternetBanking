/**
 * Test Case ID: TC_ExchangeRate_002
 * Generated from Jira Ticket: BANK-3075
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:24:23
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.webapp.bankingportal.services.AccountService;
import com.webapp.bankingportal.services.TokenService;
import com.webapp.bankingportal.repositories.UserRepository;
import com.webapp.bankingportal.entities.User;

public class CurrencyExchangeRateTest {

    private WebDriver driver;
    private AccountService accountService;
    private TokenService tokenService;
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();

        // Mock services
        accountService = Mockito.mock(AccountService.class);
        tokenService = Mockito.mock(TokenService.class);
        userRepository = Mockito.mock(UserRepository.class);

        // Example user data
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");
        when(userRepository.findByUsername(any(String.class))).thenReturn(user);

        // Open the currency exchange page
        driver.get("http://localhost:8080/currency-exchange");
    }

    @Test
    public void testExchangeRateUpdatesInRealTime() throws InterruptedException {
        // Wait for 5 minutes (300 seconds)
        Thread.sleep(300000);

        // Observe the exchange rate element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exchange-rate-INR-USD")));

        // Get the displayed exchange rate
        String exchangeRate = driver.findElement(By.id("exchange-rate-INR-USD")).getText();

        // Assert that the exchange rate is not empty and is updated
        assertTrue(exchangeRate != null && !exchangeRate.isEmpty(), "Exchange rate should be updated in real-time.");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}