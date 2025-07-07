/**
 * Test Case ID: TC_Forex_003
 * Generated from Jira Ticket: BANK-3148
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:42:21
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.*;
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

    @InjectMocks
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");

        // Mock user login
        when(userRepository.findByUsername(anyString())).thenReturn(user);
        when(tokenService.generateToken(any())).thenReturn("mockToken");
    }

    @Test
    public void testForexTransactionNotification() {
        // Step 1: Log in
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testUser");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testPassword");

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Step 2: Initiate forex transaction
        WebElement forexButton = driver.findElement(By.id("forexTransactionButton"));
        forexButton.click();

        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("1000");

        WebElement submitButton = driver.findElement(By.id("submitForexTransaction"));
        submitButton.click();

        // Step 3: Check for notification
        WebElement notification = driver.findElement(By.id("notification"));
        assertNotNull(notification);
        assertEquals("Forex transaction completed successfully!", notification.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}