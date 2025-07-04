/**
 * Test Case ID: TC_Exchange_003
 * Generated from Jira Ticket: BANK-2964
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:50:47
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExchangeRateDisplayTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testDisplayExchangeRate() {
        // Mocking the service response
        when(accountService.getExchangeRate("INR", "USD"))
            .thenReturn(new ExchangeRateResponse(74.85, "2023-10-01T12:00:00Z"));

        // Simulate user action to view exchange rate
        driver.findElement(By.id("view-exchange-rate-button")).click();

        // Assertions
        String exchangeRate = driver.findElement(By.id("exchange-rate-display")).getText();
        String lastUpdated = driver.findElement(By.id("last-updated-timestamp")).getText();

        assertTrue(exchangeRate.contains("74.85"), "Exchange rate should be displayed correctly");
        assertTrue(lastUpdated.contains("2023-10-01"), "Last updated timestamp should be displayed correctly");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
