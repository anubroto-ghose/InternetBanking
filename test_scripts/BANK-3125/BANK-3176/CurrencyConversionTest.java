/**
 * Test Case ID: TC_ConvertCurrency_003
 * Generated from Jira Ticket: BANK-3176
 * Epic: BANK-3125
 * Generated on: 2025-07-07 11:31:23
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyConversionTest {

    private WebDriver driver;

    @Test
    public void testCurrencyConversionResponseTime() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        String baseUrl = "http://localhost:8080/accounts/forex/convert";

        for (int i = 0; i < 5; i++) {
            long startTime = System.currentTimeMillis();
            driver.get(baseUrl);

            WebElement amountInput = driver.findElement(By.id("amount"));
            amountInput.sendKeys("1000");

            driver.findElement(By.id("submitBtn")).click();

            long endTime = System.currentTimeMillis();
            long responseTime = endTime - startTime;

            assertTrue(responseTime < 2000, "Response time should be less than 2 seconds");
        }

        driver.quit();
    }
}