/**
 * Test Case ID: TC_Exchange_001
 * Generated from Jira Ticket: BANK-2962
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:36:38
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class ExchangeRateTest {

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080"); // Assuming the application runs on this URL
    }

    @Test
    public void testFetchExchangeRate() {
        // Mocking the response
        when(accountService.fetchExchangeRate("INR", "USD"))
            .thenReturn("74.85"); // Mocked exchange rate

        // Simulating user action to fetch exchange rate
        WebElement fetchRateButton = driver.findElement(By.id("fetchRateButton"));
        fetchRateButton.click();

        // Wait for the exchange rate to be displayed
        WebElement exchangeRateElement = driver.findElement(By.id("exchangeRate"));
        String displayedRate = exchangeRateElement.getText();

        // Validate the result
        assertEquals("74.85", displayedRate);
        assertTrue(exchangeRateElement.isDisplayed());

        WebElement timestampElement = driver.findElement(By.id("lastUpdated"));
        assertTrue(timestampElement.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}