/**
 * Test Case ID: TC_ForexConverter_005
 * Generated from Jira Ticket: BANK-3173
 * Epic: BANK-3125
 * Generated on: 2025-07-07 11:33:16
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CurrencyConversionTest {

    private WebDriver driver;

    @Test
    public void testAdminAccessCurrencyConversion() {
        // Open browser and navigate to the web page
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/admin/forex/convert");

        // Perform assertion for error message
        String errorMessage = driver.findElement(By.id("error-message")).getText();
        assertEquals("Error: Admin access required for currency conversion", errorMessage);

        // Close the browser
        driver.quit();
    }
}