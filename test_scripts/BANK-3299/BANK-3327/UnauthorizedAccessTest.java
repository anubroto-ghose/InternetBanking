/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3327
 * Epic: BANK-3299
 * Generated on: 2025-07-15 13:41:27
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UnauthorizedAccessTest {

    private WebDriver driver;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AccountService accountService;

    @InjectMocks
    @Autowired
    private TokenService tokenService;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testUnauthorizedAccessForHighRiskAccount() {
        // Given
        String highRiskAccountId = "12345";
        String expectedUrl = "/accounts/" + highRiskAccountId + "/transactions";
        String unauthorizedMessage = "Unauthorized access";

        // Mock the service response
        when(accountService.getTransactionsFromAccountId(highRiskAccountId)).thenThrow(new RuntimeException(unauthorizedMessage));

        // When
        driver.get("http://localhost:8080" + expectedUrl);

        // Then
        String actualMessage = driver.findElement(By.tagName("body")).getText();
        assertEquals(unauthorizedMessage, actualMessage);
    }
}
