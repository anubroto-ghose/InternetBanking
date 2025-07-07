/**
 * Test Case ID: TC_Forex_004
 * Generated from Jira Ticket: BANK-3154
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:54:30
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class ForexTransactionTest {

    private WebDriver driver;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testInitiateForexTransactionWithNonExistentCustomer() {
        // Mocking the behavior of userRepository
        when(userRepository.findById(any())).thenReturn(null);

        // Simulating the forex transaction initiation
        WebElement initiateTransactionButton = driver.findElement(By.id("initiate-transaction"));
        initiateTransactionButton.click();

        // Simulating input for non-existent customer
        WebElement customerIdInput = driver.findElement(By.id("customerId"));
        customerIdInput.sendKeys("nonexistent_customer_id");

        WebElement submitButton = driver.findElement(By.id("submit-transaction"));
        submitButton.click();

        // Verifying the error message
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        assertTrue(errorMessage.isDisplayed());
        assertEquals("Customer not found", errorMessage.getText());
    }
}