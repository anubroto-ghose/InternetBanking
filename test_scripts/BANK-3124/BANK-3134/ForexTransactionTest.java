/**
 * Test Case ID: TC_Forex_001
 * Generated from Jira Ticket: BANK-3134
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:46:24
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForexTransactionTest {

    private WebDriver driver;

    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testSuccessfulForexTransaction() {
        // Assuming valid OAuth 2.0 token is available
        String oauthToken = "Bearer valid_access_token";
        String forexTransactionUrl = "http://localhost:8080/api/forex/transaction";

        // Step 1: Send a valid forex transaction request with OAuth 2.0 token
        WebElement transactionButton = driver.findElement(By.id("transactionButton"));
        transactionButton.click();

        // Mocking a successful response
        String response = restTemplate.postForObject(forexTransactionUrl, new AmountRequest(1000, "USD", "EUR"), String.class);

        // Step 2: Verify the response code and message
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("Transaction successful"));

        // Additional verification for audit logs can be added here
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}