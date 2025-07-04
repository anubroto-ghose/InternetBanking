/**
 * Test Case ID: TC_Conversion_001
 * Generated from Jira Ticket: BANK-2949
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:40:15
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountServiceIntegrationTest {

    private WebDriver driver;

    @MockBean
    private UserRepository userRepository;
    
    @Mock
    private RestTemplate restTemplate;
    
    @InjectMocks
    @Autowired
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFallbackToCachedExchangeRate() {
        // Simulate API downtime
        when(restTemplate.getForEntity(any(String.class), any(Class.class))).thenThrow(new RuntimeException("API Unreachable"));

        // Mock the last known exchange rate
        when(accountService.getLastKnownExchangeRate()).thenReturn(1.2);

        // Trigger the action that uses the exchange rate
        driver.findElement(By.id("triggerExchangeRate"))
              .click();

        // Wait for the result to be displayed
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exchangeRateResult")));

        // Validate that the system used the cached rate
        String resultText = driver.findElement(By.id("exchangeRateResult")).getText();
        assertEquals("Using cached exchange rate: 1.2", resultText);
    }
}