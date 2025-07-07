/**
 * Test Case ID: TC_Forex_004
 * Generated from Jira Ticket: BANK-3154
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:40:48
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
    private ForexController forexController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testInitiateForexTransactionWithNonExistentCustomer() {
        // Mocking the user repository to return null for non-existent customer
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        // Simulate the forex transaction initiation
        WebElement initiateButton = driver.findElement(By.id("initiateForexTransaction"));
        initiateButton.click();

        // Input non-existent customer details
        WebElement customerIdField = driver.findElement(By.id("customerId"));
        customerIdField.sendKeys("nonExistentCustomerId");

        WebElement submitButton = driver.findElement(By.id("submitTransaction"));
        submitButton.click();

        // Verify the response
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertEquals("Customer not found", errorMessage.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
