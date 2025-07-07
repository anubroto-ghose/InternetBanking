/**
 * Test Case ID: TC_Forex_004
 * Generated from Jira Ticket: BANK-3149
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:09:33
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

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
        loginUser();
    }

    private void loginUser() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testUser");
        passwordField.sendKeys("password123");
        loginButton.click();
    }

    @Test
    public void testForexTransactionNotification() throws InterruptedException {
        when(accountService.initiateForexTransaction("testUser", 1000)).thenThrow(new RuntimeException("Transaction failed"));

        WebElement forexButton = driver.findElement(By.id("forexButton"));
        forexButton.click();

        Thread.sleep(2000); // wait for the transaction to process

        WebElement notification = driver.findElement(By.id("notification"));
        assertTrue(notification.isDisplayed(), "Notification was not displayed");
        assertTrue(notification.getText().contains("Transaction failed"), "Notification message is incorrect");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}