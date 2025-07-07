/**
 * Test Case ID: TC_Forex_003
 * Generated from Jira Ticket: BANK-3148
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:09:50
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ForexTransactionNotificationTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");

        // Simulate login
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password");
        loginButton.click();
    }

    @Test
    public void testForexTransactionNotification() {
        // Mock services
        when(accountService.initiateForexTransaction(any())).thenReturn(true);
        when(accountService.completeForexTransaction(any())).thenReturn(true);

        // Initiate Forex Transaction
        boolean transactionInitiated = accountService.initiateForexTransaction(new AmountRequest(1000, "USD", "EUR"));
        assertTrue(transactionInitiated, "Forex transaction should be initiated successfully.");

        // Complete Forex Transaction
        boolean transactionCompleted = accountService.completeForexTransaction(new AmountRequest(1000, "USD", "EUR"));
        assertTrue(transactionCompleted, "Forex transaction should be completed successfully.");

        // Check Notification
        WebElement notificationElement = driver.findElement(By.id("notification"));
        assertTrue(notificationElement.isDisplayed(), "Notification should be displayed after transaction completion.");
        assertEquals("Forex transaction completed successfully!", notificationElement.getText(), "Notification message is incorrect.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}