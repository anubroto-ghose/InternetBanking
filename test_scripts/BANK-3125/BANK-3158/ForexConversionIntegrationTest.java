/**
 * Test Case ID: TC_ForexConversion_001
 * Generated from Jira Ticket: BANK-3158
 * Epic: BANK-3125
 * Generated on: 2025-07-07 11:41:24
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForexConversionIntegrationTest {

    @Test
    public void testForexConversionWithExpiredToken() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://bankingportal.com/forexConversion");
        String title = driver.getTitle();
        assertEquals("401 Unauthorized", title);
        driver.quit();
    }
}