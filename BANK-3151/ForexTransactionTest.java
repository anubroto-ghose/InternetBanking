/**
 * Test Case ID: TC_Forex_001
 * Generated from Jira Ticket: BANK-3151
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:08:52
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Assertions;
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

@SpringBootTest
public class ForexTransactionTest {

    @Autowired
    private RestTemplate restTemplate;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testInitiateForexTransaction() throws InterruptedException {
        // Mocking account service response
        when(accountService.initiateForexTransaction(any(AmountRequest.class))).thenReturn(new ResponseEntity<>("Transaction Successful", HttpStatus.OK));

        // Input data
        WebElement amountInput = driver.findElement(By.id("amount"));
        amountInput.sendKeys("1000"); // INR amount

        WebElement currencyFrom = driver.findElement(By.id("currencyFrom"));
        currencyFrom.sendKeys("INR");

        WebElement currencyTo = driver.findElement(By.id("currencyTo"));
        currencyTo.sendKeys("JPY");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Wait for response
        Thread.sleep(2000);

        // Assertions
        WebElement responseMessage = driver.findElement(By.id("responseMessage"));
        Assertions.assertEquals("Transaction Successful", responseMessage.getText());

        // Further validation can be added here
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}