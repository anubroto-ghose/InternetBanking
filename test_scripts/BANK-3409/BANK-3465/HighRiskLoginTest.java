/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3465
 * Epic: BANK-3409
 * Generated on: 2025-07-15 13:29:36
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

public class HighRiskLoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHighRiskLogin() {
        driver.get("http://localhost:8080/login");

        // Step 1: Enter valid username and password
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("testuser");
        passwordField.sendKeys("validPassword");

        // Step 2: Submit the login form
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Step 3: Wait for the additional authentication prompt
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("additionalAuthPrompt")));

        // Step 4: Complete additional authentication steps
        WebElement otpField = driver.findElement(By.id("otp"));
        otpField.sendKeys("123456"); // Simulating OTP input
        WebElement verifyButton = driver.findElement(By.id("verifyButton"));
        verifyButton.click();

        // Step 5: Verify successful login
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        assertEquals("http://localhost:8080/dashboard", driver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}