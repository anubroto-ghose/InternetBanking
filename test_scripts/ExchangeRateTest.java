/**
 * Test Case ID: TC_Exchange_001
 * Generated from Jira Ticket: BANK-2962
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:51:19
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

public class ExchangeRateTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testFetchCurrentINRToUSDRates() {
        // Navigate to the banking portal
        driver.get("http://localhost:8080");

        // Simulate user requesting exchange rate
        WebElement exchangeRateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("exchangeRateButton")));
        exchangeRateButton.click();

        // Wait for the exchange rate to be displayed
        WebElement exchangeRate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentExchangeRate")));
        WebElement timestamp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastUpdated")));

        // Assertions
        assertNotNull(exchangeRate.getText(), "Exchange rate should not be null");
        assertNotNull(timestamp.getText(), "Timestamp should not be null");
        assertTrue(exchangeRate.getText().matches("^\d+\.\d{2} USD$"), "Exchange rate format is incorrect");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}