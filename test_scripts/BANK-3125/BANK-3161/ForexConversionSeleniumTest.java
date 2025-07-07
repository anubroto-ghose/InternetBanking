/**
 * Test Case ID: TC_Forex_002
 * Generated from Jira Ticket: BANK-3161
 * Epic: BANK-3125
 * Generated on: 2025-07-07 11:39:30
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ForexConversionSeleniumTest {

    WebDriver driver;

    @Test
    public void testForexConversionWithInsufficientFunds() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://bankingapp.com");

        // Login operation with valid credentials
        driver.findElement(By.id("username")).sendKeys("user123");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginBtn")).click();

        // Navigate to forex conversion section
        driver.findElement(By.id("forexBtn")).click();

        // Enter conversion details
        driver.findElement(By.id("currencyPair")).sendKeys("USD-EUR");
        driver.findElement(By.id("amount")).sendKeys("1000");
        driver.findElement(By.id("convertBtn")).click();

        // Assertion for error message
        String errorMessage = driver.findElement(By.id("errorText")).getText();
        assert(errorMessage.contains("Insufficient funds"));

        driver.quit();
    }
}