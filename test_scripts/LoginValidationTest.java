/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3464
 * Epic: BANK-3409
 * Generated on: 2025-07-14 10:49:07
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginValidationTest {

    private WebDriver driver;

    @Test
    public void testInvalidLogin() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.get("http://bankingportal.com/login");
        // Enter valid username
        driver.findElement(By.id("username")).sendKeys("testuser");
        // Enter incorrect password
        driver.findElement(By.id("password")).sendKeys("incorrectpassword");
        // Click on login button
        driver.findElement(By.id("loginBtn")).click();
        // Assert error message
        assertEquals("Incorrect credentials provided", driver.findElement(By.id("error-msg")).getText());
        // Close the browser
        driver.quit();
    }
}