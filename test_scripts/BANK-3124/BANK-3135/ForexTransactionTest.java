/**
 * Test Case ID: TC_Forex_002
 * Generated from Jira Ticket: BANK-3135
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:46:10
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
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ForexTransactionTest {

    private WebDriver driver;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private AccountService accountService;

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
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testUnsuccessfulForexTransactionWithInvalidToken() {
        // Mocking the token service to return an invalid token response
        when(tokenService.validateToken("invalid-token")).thenReturn(false);
        when(accountService.performForexTransaction("invalid-token", 1000)).thenReturn(new ResponseEntity<>("Token authentication failed", HttpStatus.UNAUTHORIZED));

        // Simulate sending the forex transaction request
        WebElement forexInput = driver.findElement(By.id("forexInput"));
        forexInput.sendKeys("1000");

        WebElement submitButton = driver.findElement(By.id("submitForex"));
        submitButton.click();

        // Validate the response
        WebElement responseMessage = driver.findElement(By.id("responseMessage"));
        assertEquals("Token authentication failed", responseMessage.getText());
        assertEquals("401", driver.findElement(By.id("responseCode")).getText());
    }
}