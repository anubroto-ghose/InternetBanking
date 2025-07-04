/**
 * Test Case ID: TC_Conversion_001
 * Generated from Jira Ticket: BANK-3056
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:28:06
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyConversionTest {

    private WebDriver driver;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        // Mocking the external service to simulate API downtime
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        when(restTemplate.getForObject(any(String.class), any(Class.class))).thenThrow(new RuntimeException("API Down"));
    }

    @Test
    public void testCurrencyConversionFallback() {
        driver.get("http://localhost:8080/bankingportal");

        // Find and fill in the currency conversion form
        WebElement amountInput = driver.findElement(By.id("amountInput"));
        amountInput.sendKeys("100");

        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Check for the expected fallback behavior
        WebElement result = driver.findElement(By.id("conversionResult"));
        assertEquals("Last known exchange rate: 1.2", result.getText(), "The conversion should use the last known exchange rate");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}