/**
 * Test Case ID: TC_Exchange_002
 * Generated from Jira Ticket: BANK-2963
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:36:22
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExchangeRateUpdateTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private AccountService accountService;
    private UserRepository userRepository;
    private TokenService tokenService;

    @BeforeEach
    public void setUp() {
        // Set up WebDriver and mocks
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        accountService = mock(AccountService.class);
        userRepository = mock(UserRepository.class);
        tokenService = mock(TokenService.class);

        // Mocking behavior for account service
        when(accountService.getExchangeRate("INR", "USD")).thenReturn(74.85);
        when(accountService.getExchangeRate("INR", "USD")).thenReturn(74.90);
    }

    @Test
    public void testExchangeRateUpdateInRealTime() throws InterruptedException {
        // Navigate to the exchange rate page
        driver.get("http://localhost:8080/exchange-rate");

        // Wait for the initial exchange rate to be displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exchangeRate")));
        String initialRate = driver.findElement(By.id("exchangeRate")).getText();

        // Simulate waiting for the exchange rate to update
        Thread.sleep(15000); // Wait for 15 seconds to allow for background refresh

        // Get the updated exchange rate
        String updatedRate = driver.findElement(By.id("exchangeRate")).getText();

        // Assert that the exchange rate has been updated
        assertEquals("74.90", updatedRate);
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
