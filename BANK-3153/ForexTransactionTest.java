/**
 * Test Case ID: TC_Forex_003
 * Generated from Jira Ticket: BANK-3153
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:54:48
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ForexTransactionTest {

    private WebDriver driver;

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testInitiateForexTransactionWithInvalidCurrency() {
        // Mocking the response for an invalid currency type
        when(restTemplate.postForEntity(any(String.class), any(AmountRequest.class), any(Class.class)))
            .thenReturn(new ResponseEntity<>("Invalid currency type", HttpStatus.BAD_REQUEST));

        // Fill in the forex transaction form
        WebElement currencyField = driver.findElement(By.id("currencyType"));
        currencyField.sendKeys("INVALID_CURRENCY");

        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("1000");

        WebElement submitButton = driver.findElement(By.id("submitTransaction"));
        submitButton.click();

        // Verify the error message
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        String actualMessage = errorMessage.getText();
        assertTrue(actualMessage.contains("Invalid currency type"), "Error message not displayed as expected");

        // Verify no amount was deducted (mocked service)
        assertEquals(10000, accountService.getAccountBalance(), "Account balance should remain unchanged");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}