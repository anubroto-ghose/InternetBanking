/**
 * Test Case ID: TC_Forex_005
 * Generated from Jira Ticket: BANK-3155
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:54:13
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ForexTransactionTest {

    private WebDriver driver;

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testInitiateForexTransaction() throws InterruptedException {
        // Mocking the response for the forex transaction
        AmountRequest request = new AmountRequest(10000, "JPY", "INR");
        ResponseEntity<String> mockResponse = ResponseEntity.ok("Transaction initiated successfully");
        when(restTemplate.postForEntity(anyString(), any(), eq(String.class))).thenReturn(mockResponse);

        // Locate and fill in the forex transaction form
        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("10000");

        WebElement fromCurrencyField = driver.findElement(By.id("fromCurrency"));
        fromCurrencyField.sendKeys("JPY");

        WebElement toCurrencyField = driver.findElement(By.id("toCurrency"));
        toCurrencyField.sendKeys("INR");

        WebElement submitButton = driver.findElement(By.id("submitTransaction"));
        submitButton.click();

        // Wait for a short period for the response
        Thread.sleep(2000);

        // Verify the response
        WebElement responseMessage = driver.findElement(By.id("responseMessage"));
        assertEquals("Transaction initiated successfully", responseMessage.getText());

        // Verify that the account balance has been updated
        verify(accountService).deductAmount(anyInt(), eq("JPY"));
        verify(accountService).creditAmount(anyInt(), eq("INR"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}