/**
 * Test Case ID: TC_Exchange_002
 * Generated from Jira Ticket: BANK-2963
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:51:03
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testExchangeRateUpdate() throws InterruptedException {
        // Mocking the exchange rate response
        when(accountService.getExchangeRate("INR", "USD")).thenReturn(75.0);

        // Wait for the exchange rate to be displayed
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exchangeRate")));

        // Get initial exchange rate
        String initialRate = driver.findElement(By.id("exchangeRate")).getText();
        assertEquals("75.0", initialRate);

        // Simulate waiting for the update
        Thread.sleep(10000); // Wait for 10 seconds

        // Mocking the updated exchange rate response
        when(accountService.getExchangeRate("INR", "USD")).thenReturn(76.0);

        // Wait for the exchange rate to be updated
        wait.until(ExpectedConditions.textToBe(By.id("exchangeRate"), "76.0"));

        // Get updated exchange rate
        String updatedRate = driver.findElement(By.id("exchangeRate")).getText();
        assertEquals("76.0", updatedRate);
    }
}