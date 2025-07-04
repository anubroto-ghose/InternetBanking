/**
 * Test Case ID: TC_ExchangeRate_003
 * Generated from Jira Ticket: BANK-3076
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:24:06
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.RequestBody;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ExchangeRateTest {

    private WebDriver driver;

    @Mock
    private AccountService accountService;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testExchangeRateDisplaysTimestamp() {
        // Mocking service responses
        when(accountService.getCurrentExchangeRate()).thenReturn(new ResponseEntity<>(new ExchangeRateResponse(1.23, "2023-10-01T12:00:00Z"), HttpStatus.OK));

        // Simulate user action to retrieve exchange rate
        WebElement retrieveButton = driver.findElement(By.id("retrieveExchangeRate"));
        retrieveButton.click();

        // Observe the displayed exchange rate
        WebElement exchangeRateElement = driver.findElement(By.id("exchangeRate"));
        String displayedRate = exchangeRateElement.getText();

        // Check for the presence of a timestamp
        WebElement timestampElement = driver.findElement(By.id("lastUpdated"));
        String displayedTimestamp = timestampElement.getText();

        // Assertions
        assertTrue(displayedRate.contains("1.23"), "Exchange rate not displayed correctly.");
        assertTrue(displayedTimestamp.contains("2023-10-01T12:00:00Z"), "Timestamp not displayed correctly.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
