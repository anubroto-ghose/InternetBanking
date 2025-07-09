/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3334
 * Epic: BANK-3299
 * Generated on: 2025-07-09 09:37:58
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void testSuccessfulLogin() {
        driver.get("http://localhost:8080/login");
        driver.findElement(By.id("username")).sendKeys("john_doe");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginBtn")).click();
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
        assertFalse(driver.getPageSource().contains("Error"));
    }
}