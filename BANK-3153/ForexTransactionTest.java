/**
 * Test Case ID: TC_Forex_003
 * Generated from Jira Ticket: BANK-3153
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:08:16
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ForexTransactionTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenService tokenService;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private ForexTransactionService forexTransactionService;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        // Mock responses
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(new User()));
    }

    @Test
    public void testInitiateForexTransactionWithInvalidCurrency() {
        // Navigate to forex transaction page
        driver.get("http://localhost:8080/forex");

        // Fill in the amount
        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("100");

        // Attempt to initiate transaction with invalid currency type
        WebElement currencyField = driver.findElement(By.id("currency"));
        currencyField.sendKeys("INVALID_CURRENCY");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verify response
        WebElement errorMessage = driver.findElement(By.id("error"));
        assertEquals("Invalid currency type", errorMessage.getText());

        // Verify that no amount was deducted
        verify(accountService, never()).deductAmount(anyLong(), anyDouble());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
