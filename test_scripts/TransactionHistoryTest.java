/**
 * Test Case ID: TC_ViewTransaction_002
 * Generated from Jira Ticket: BANK-2953
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:39:11
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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionHistoryTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost:8080/login");
        login();
    }

    private void login() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password");
        driver.findElement(By.id("loginButton")).click();
    }

    @Test
    public void testViewTransactionHistoryNoData() {
        driver.findElement(By.id("transactionHistoryButton")).click();
        WebElement noDataMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noDataMessage")));
        assertTrue(noDataMessage.isDisplayed(), "No transaction data message should be displayed.");
        assertTrue(noDataMessage.getText().contains("No conversion data available"), "Expected message not found.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}