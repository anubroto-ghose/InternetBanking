/**
 * Test Case ID: TC_Conversion_001
 * Generated from Jira Ticket: BANK-3060
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:27:38
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CurrencyConversionTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080"); // Assuming the app runs locally
    }

    @Test
    public void testCurrencyConversionFallback() {
        // Mocking the behavior of the external service
        when(accountService.convertCurrency("USD", "EUR", 100)).thenThrow(new RuntimeException("API Down"));
        when(accountService.getLastKnownExchangeRate("USD", "EUR")).thenReturn(0.85);

        // Attempt to convert currency
        WebElement amountInput = driver.findElement(By.id("amount"));
        amountInput.sendKeys("100");
        WebElement fromCurrency = driver.findElement(By.id("fromCurrency"));
        fromCurrency.sendKeys("USD");
        WebElement toCurrency = driver.findElement(By.id("toCurrency"));
        toCurrency.sendKeys("EUR");
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Observe the system's response
        WebElement result = driver.findElement(By.id("result"));
        assertEquals("85.00", result.getText(), "The conversion result should fallback to the cached rate.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
