/**
 * Test Case ID: TC_ExchangeRate_004
 * Generated from Jira Ticket: BANK-3077
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:23:43
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ExchangeRateAPITest {

    private WebDriver driver;

    @MockBean
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080"); // Adjust based on your app
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testExchangeRateAPIDowntime() {
        // Mock the external API call to simulate downtime
        when(restTemplate.getForEntity("http://api.exchangerates.com/latest?base=INR", String.class))
                .thenReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE));

        // Attempt to fetch the exchange rate
        WebElement fetchButton = driver.findElement(By.id("fetchRate"));
        fetchButton.click();

        // Check for error message
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertEquals("Could not retrieve exchange rate due to API downtime.", errorMessage.getText());
    }
}