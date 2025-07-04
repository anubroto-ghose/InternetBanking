/**
 * Test Case ID: TC_Exchange_003
 * Generated from Jira Ticket: BANK-2964
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:36:08
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeRateDisplayTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testDisplayExchangeRateWithTimestamp() {
        // Mocking the response from the AccountService
        when(accountService.getExchangeRate()).thenReturn(new ExchangeRateResponse(74.85, "2023-10-01T12:00:00Z"));

        // Simulating user action to view the exchange rate
        WebElement exchangeRateElement = driver.findElement(By.id("exchangeRate"));
        WebElement timestampElement = driver.findElement(By.id("lastUpdated"));

        // Asserting that the exchange rate and timestamp are displayed correctly
        assertEquals("74.85", exchangeRateElement.getText());
        assertEquals("Last updated: 2023-10-01T12:00:00Z", timestampElement.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
