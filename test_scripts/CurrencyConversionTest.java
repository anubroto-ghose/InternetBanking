/**
 * Test Case ID: TC_Conversion_005
 * Generated from Jira Ticket: BANK-3064
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:26:48
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyConversionTest {

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
    }

    @Test
    public void testCurrencyConversionDuringApiDowntime() {
        // Mocking the service to simulate API downtime
        when(accountService.convertCurrency(any())).thenThrow(new RuntimeException("API is down"));

        driver.get("http://localhost:8080/currency-conversion");

        // Start the conversion process
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Check for the message on the UI
        WebElement messageElement = driver.findElement(By.id("message"));
        String message = messageElement.getText();

        // Assert the message and ensure UI remains responsive
        assertTrue(message.contains("Using cached rates"), "User should be informed about cached rates");
        assertEquals("200 OK", driver.getTitle(), "The UI should remain responsive");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}