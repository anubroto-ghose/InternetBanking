/**
 * Test Case ID: TC_Forex_005
 * Generated from Jira Ticket: BANK-3150
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:55:35
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

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
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ForexTransactionDetailsTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testDisplayTransactionDetails() {
        // Mocking the necessary service responses
        when(userRepository.findUserById(1L)).thenReturn(new User(1L, "testuser", "password"));
        when(accountService.getForexTransactions(1L)).thenReturn(Arrays.asList(
            new ForexTransaction(1000, "INR"),
            new ForexTransaction(2000, "JPY")
        ));

        // Simulate user login
        driver.get("http://localhost:8080/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password");
        loginButton.click();

        // Navigate to forex transactions section
        driver.get("http://localhost:8080/forex-transactions");

        // Check for displayed transaction details
        WebElement transactionDetails = driver.findElement(By.id("transactionDetails"));
        String transactionText = transactionDetails.getText();

        assertEquals(true, transactionText.contains("1000 INR") || transactionText.contains("2000 JPY"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}