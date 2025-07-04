/**
 * Test Case ID: TC_Conversion_004
 * Generated from Jira Ticket: BANK-3063
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:27:04
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyConversionTest {

    private WebDriver driver;

    @Mock
    private TokenService tokenService;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCurrencyConversionWhenApiIsDown() {
        // Mocking the external API calls to simulate downtime
        when(accountService.getExchangeRate()).thenThrow(new RuntimeException("API is down"));

        // Simulate user input for currency conversion
        WebElement amountInput = driver.findElement(By.id("amount"));
        amountInput.sendKeys("100");
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Observe the system response
        String notificationMessage = driver.findElement(By.id("notificationMessage")).getText();
        assertEquals("API is unreachable, using cached exchange rate.", notificationMessage);

        // Verify that the service was called
        verify(accountService, times(1)).getExchangeRate();
    }
}