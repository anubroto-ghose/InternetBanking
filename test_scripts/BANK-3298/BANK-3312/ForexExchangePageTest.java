/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3312
 * Epic: BANK-3298
 * Generated on: 2025-07-09 09:45:10
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForexExchangePageTest {

    WebDriver driver;
    
    @Test
    public void testForexExchangePage() {
        driver = new ChromeDriver();
        driver.get("http://bankingportal.com/forexexchange");
        driver.findElement(By.id("currencyDropdown")).click();
        driver.findElement(By.xpath("//option[text()='USD']")).click();
        driver.findElement(By.id("exchangeAmount")).sendKeys("100");
    }
}