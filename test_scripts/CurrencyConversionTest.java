/**
 * Test Case ID: TC_Conversion_002
 * Generated from Jira Ticket: BANK-3057
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:27:53
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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest
@RestController
public class CurrencyConversionTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testCurrencyConversionApiDown() {
        // Mocking the behavior of the external API
        when(accountService.convertCurrency(any(AmountRequest.class))).thenReturn(new ResponseEntity<>("API is down", HttpStatus.SERVICE_UNAVAILABLE));

        driver.get("http://localhost:8080/bankingportal");

        // Simulating currency conversion
        WebElement amountInput = driver.findElement(By.id("amountInput"));
        amountInput.sendKeys("100");

        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Check for error message
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertEquals("API is down", errorMessage.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}