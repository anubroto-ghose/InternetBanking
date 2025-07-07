/**
 * Test Case ID: TC_Forex_005
 * Generated from Jira Ticket: BANK-3150
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:09:09
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionDetailsTest {

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
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
        // Simulate login
        loginUser();
    }

    private void loginUser() {
        // Mock login
        LoginRequest loginRequest = new LoginRequest("username", "password");
        when(tokenService.login(any())).thenReturn(new ResponseEntity<>("token", HttpStatus.OK));
        driver.findElement(By.id("username")).sendKeys(loginRequest.getUsername());
        driver.findElement(By.id("password")).sendKeys(loginRequest.getPassword());
        driver.findElement(By.id("loginButton")).click();
    }

    @Test
    public void testDisplayTransactionDetails() {
        // Mock transaction details
        when(accountService.getTransactionDetails(any())).thenReturn(new ResponseEntity<>(new TransactionDetails("1000", "INR"), HttpStatus.OK));

        // Navigate to forex transactions section
        driver.findElement(By.id("forexTransactionsLink")).click();

        // Check for displayed transaction details
        String displayedAmount = driver.findElement(By.id("transactionAmount")).getText();
        String displayedCurrency = driver.findElement(By.id("transactionCurrency")).getText();

        assertEquals("1000", displayedAmount);
        assertEquals("INR", displayedCurrency);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
