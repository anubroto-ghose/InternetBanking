/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3336
 * Epic: BANK-3299
 * Generated on: 2025-07-15 13:38:37
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

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost:8080/login");
    }

    @Test
    public void testSeamlessLoginForLowRiskUser() {
        // Step 1: Enter username
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("lowRiskUser");

        // Step 2: Enter password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys("securePassword123");

        // Step 3: Click on 'Login' button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Expected Results: User is logged in seamlessly
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        assertNotNull(dashboard);
        assertEquals("Welcome to your dashboard!", dashboard.getText());

        // Additional assertion to ensure the user is redirected correctly
        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}