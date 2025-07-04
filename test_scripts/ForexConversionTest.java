/**
 * Test Case ID: TC_Forex_004
 * Generated from Jira Ticket: BANK-3098
 * Epic: BANK-3083
 * Generated on: 2025-07-04 14:11:36
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ForexConversionTest {

    WebDriver driver;

    @Test
    public void testMalformedForexRequestErrorMessage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/forex/conversion");
        // Perform forex conversion with malformed data
        // Validate error message
        assertEquals("Expected error message", driver.findElement(By.id("error-message")).getText());
        driver.quit();
    }
}