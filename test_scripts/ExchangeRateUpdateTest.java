/**
 * Test Case ID: TC_Exchange_002
 * Generated from Jira Ticket: BANK-2963
 * Epic: BANK-749
 * Generated on: 2025-07-04 17:44:12
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ExchangeRateUpdateTest {

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
        driver.get("http://localhost:8080/exchange-rate");
    }

    @Test
    public void testExchangeRateUpdate() throws InterruptedException {
        // Mock the service response
        when(accountService.getExchangeRate("INR", "USD")).thenReturn(75.0);

        // Wait for a period to simulate user staying on the screen
        Thread.sleep(10000);

        // Simulate background update
        when(accountService.getExchangeRate("INR", "USD")).thenReturn(76.0);

        // Locate the exchange rate element
        WebElement exchangeRateElement = driver.findElement(By.id("exchangeRate"));

        // Assert the initial exchange rate
        assertEquals("75.0", exchangeRateElement.getText());

        // Simulate real-time update
        Thread.sleep(5000); // wait for the update to occur

        // Assert the updated exchange rate
        assertEquals("76.0", exchangeRateElement.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}