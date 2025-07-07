/**
 * Test Case ID: TC_Forex_004
 * Generated from Jira Ticket: BANK-3149
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:42:05
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.*;
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
@ExtendWith(SpringExtension.class)
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
        driver.get("http://localhost:8080/login");
    }

    @Test
    public void testForexTransactionNotification() {
        // Mock user login
        LoginRequest loginRequest = new LoginRequest("testuser", "password");
        when(userRepository.findByUsername("testuser")).thenReturn(new User());

        // Perform login
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameInput.sendKeys(loginRequest.getUsername());
        passwordInput.sendKeys(loginRequest.getPassword());
        loginButton.click();

        // Initiate a forex transaction
        WebElement forexButton = driver.findElement(By.id("forexTransactionButton"));
        forexButton.click();

        // Simulate a transaction failure
        when(accountService.initiateForexTransaction(any())).thenThrow(new RuntimeException("Transaction failed"));

        // Cancel the transaction
        WebElement cancelButton = driver.findElement(By.id("cancelButton"));
        cancelButton.click();

        // Check for notification
        WebElement notification = driver.findElement(By.id("notification"));
        assertTrue(notification.isDisplayed(), "Notification should be displayed");
        assertEquals("Transaction failed", notification.getText(), "Notification message should match");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}