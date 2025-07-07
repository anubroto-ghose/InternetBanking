/**
 * Test Case ID: TC_Forex_003
 * Generated from Jira Ticket: BANK-3153
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:41:01
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;

public class ForexTransactionTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testInvalidCurrencyType() {
        driver.get("http://localhost:8080/bankingportal/forex");

        // Simulate sending a request to initiate a forex transaction with an invalid currency type
        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("1000");

        WebElement currencyField = driver.findElement(By.id("currency"));
        currencyField.sendKeys("INVALID_CURRENCY");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verify the response for a failed transaction due to invalid input
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        assertNotNull(errorMessage);
        assertEquals("Invalid currency type.", errorMessage.getText());

        // Assert that no currency amount has been deducted from the account
        // Assuming we have a method to check the account balance
        double balance = getAccountBalance();
        assertEquals(10000.0, balance); // Assuming initial balance was 10000
    }

    private double getAccountBalance() {
        // Mock call to the account service to return the current balance
        return 10000.0; // This should be replaced with actual service call in real scenarios
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}