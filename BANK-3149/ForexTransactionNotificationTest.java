/**
 * Test Case ID: TC_Forex_004
 * Generated from Jira Ticket: BANK-3149
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:55:56
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ForexTransactionNotificationTest {

    private WebDriver driver;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountService accountService;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private ForexTransactionService forexTransactionService;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testForexTransactionNotification() {
        // Mock user login
        when(userRepository.findByUsername("testUser"))
                .thenReturn(new User("testUser", "testPassword"));

        // Perform login
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testUser");
        passwordField.sendKeys("testPassword");
        loginButton.click();

        // Mock forex transaction failure
        when(accountService.initiateForexTransaction(any())).thenThrow(new ForexTransactionException("Transaction failed"));

        // Initiate forex transaction
        WebElement forexButton = driver.findElement(By.id("forexButton"));
        forexButton.click();

        // Cancel forex transaction
        WebElement cancelButton = driver.findElement(By.id("cancelButton"));
        cancelButton.click();

        // Check for notification
        WebElement notification = driver.findElement(By.id("notification"));
        assertNotNull(notification);
        assertEquals("Transaction failed", notification.getText());
    }
}