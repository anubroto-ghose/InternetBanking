/**
 * Test Case ID: TC_ExchangeRate_001
 * Generated from Jira Ticket: BANK-3074
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:24:36
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
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExchangeRateTest {

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
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/currency-exchange");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testGetExchangeRate() {
        // Mocking the response from the AccountService
        when(accountService.getExchangeRate("INR", "USD")).thenReturn(75.50);

        // Click on 'Get Exchange Rate' button
        WebElement button = driver.findElement(By.id("getExchangeRateButton"));
        button.click();

        // Observe displayed exchange rate
        WebElement exchangeRateElement = driver.findElement(By.id("exchangeRateDisplay"));
        String displayedRate = exchangeRateElement.getText();

        // Assert the expected result
        assertEquals("75.50", displayedRate, "Exchange rate should be displayed correctly.");
    }
}