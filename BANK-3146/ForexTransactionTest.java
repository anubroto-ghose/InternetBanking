/**
 * Test Case ID: TC_Forex_001
 * Generated from Jira Ticket: BANK-3146
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:56:49
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
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForexTransactionTest {

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
        user = new User();
        user.setUsername("testuser");
        user.setPassword("testpass");
        when(userRepository.findByUsername("testuser")).thenReturn(user);
        when(accountService.getOngoingForexTransactions(user)).thenReturn(getMockedForexTransactions());
    }

    @Test
    public void testDisplayOngoingForexTransactions() {
        driver.get("http://localhost:8080/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testuser");
        passwordField.sendKeys("testpass");
        loginButton.click();

        driver.get("http://localhost:8080/forex-transactions");

        WebElement transactionTable = driver.findElement(By.id("transactionTable"));
        assertNotNull(transactionTable);
        assertTrue(transactionTable.isDisplayed(), "Transaction table should be displayed");

        // Verify that the table contains pending transactions
        assertTrue(transactionTable.getText().contains("Pending"), "There should be ongoing transactions with pending status");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private List<ForexTransaction> getMockedForexTransactions() {
        ForexTransaction transaction = new ForexTransaction();
        transaction.setId(1);
        transaction.setStatus("Pending");
        return Collections.singletonList(transaction);
    }
}