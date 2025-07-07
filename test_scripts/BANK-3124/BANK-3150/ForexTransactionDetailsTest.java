/**
 * Test Case ID: TC_Forex_005
 * Generated from Jira Ticket: BANK-3150
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:41:49
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
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith({MockitoExtension.class, SpringExtension.class})
public class ForexTransactionDetailsTest {

    private WebDriver driver;
    private WebDriverWait wait;

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
        wait = new WebDriverWait(driver, 10);
        // Mock user login
        when(userRepository.findByUsername("testUser")).thenReturn(user);
        when(tokenService.generateToken(user)).thenReturn("mockedToken");
        // Assuming the user is already logged in
    }

    @Test
    public void testDisplayTransactionDetails() {
        driver.get("http://localhost:8080/forex-transactions");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transaction-details")));

        String expectedAmount = "1000";
        String expectedCurrency = "INR";

        String displayedAmount = driver.findElement(By.id("amount")).getText();
        String displayedCurrency = driver.findElement(By.id("currency")).getText();

        assertEquals(expectedAmount, displayedAmount, "The displayed amount is incorrect.");
        assertEquals(expectedCurrency, displayedCurrency, "The displayed currency is incorrect.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}