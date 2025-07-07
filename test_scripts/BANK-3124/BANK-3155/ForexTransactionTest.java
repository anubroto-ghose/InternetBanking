/**
 * Test Case ID: TC_Forex_005
 * Generated from Jira Ticket: BANK-3155
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:40:34
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForexTransactionTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @InjectMocks
    private UserRepository userRepository;

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
    public void testInitiateForexTransaction() throws Exception {
        // Mocking the AccountService response
        when(accountService.initiateForexTransaction(any(AmountRequest.class))).thenReturn(ResponseEntity.ok("Transaction Successful"));

        // Sending request to initiate forex transaction
        driver.findElement(By.id("amountInput")).sendKeys("10000"); // JPY amount
        driver.findElement(By.id("currencyFrom")).sendKeys("JPY");
        driver.findElement(By.id("currencyTo")).sendKeys("INR");
        driver.findElement(By.id("initiateTransactionButton")).click();

        // Verifying response
        String responseMessage = driver.findElement(By.id("responseMessage")).getText();
        assertEquals("Transaction Successful", responseMessage);

        // Additional assertions to verify amounts
        // Assuming the expected conversion rate is 0.67
        double expectedINRAmount = 10000 * 0.67;
        double actualINRAmount = Double.parseDouble(driver.findElement(By.id("creditedAmount")).getText());
        assertEquals(expectedINRAmount, actualINRAmount);

        // Check if no error messages are displayed
        assertTrue(driver.findElements(By.className("error-message")).isEmpty());
    }
}