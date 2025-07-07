/**
 * Test Case ID: TC_Forex_003
 * Generated from Jira Ticket: BANK-3148
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:56:12
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        Mockito.when(userRepository.findById(1L)).thenReturn(new User(1L, "user@example.com", "password", "1234"));
        Mockito.when(accountService.initiateForexTransaction(Mockito.any())).thenReturn(true);
    }

    @Test
    public void testForexTransactionNotification() {
        // Step 1: Log in the user
        driver.get("http://localhost:8080/login");
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        emailField.sendKeys("user@example.com");
        passwordField.sendKeys("password");
        driver.findElement(By.id("loginButton")).click();

        // Step 2: Initiate a forex transaction
        WebElement forexButton = driver.findElement(By.id("forexTransactionButton"));
        forexButton.click();
        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("1000");
        driver.findElement(By.id("submitTransactionButton")).click();

        // Step 3: Check for notifications
        WebElement notification = driver.findElement(By.id("notification"));
        assertTrue(notification.isDisplayed(), "Notification should be displayed");
        assertEquals("Forex transaction completed successfully!", notification.getText(), "Notification message should match");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}