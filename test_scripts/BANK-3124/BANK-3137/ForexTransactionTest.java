/**
 * Test Case ID: TC_Forex_004
 * Generated from Jira Ticket: BANK-3137
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:45:23
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForexTransactionTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private ForexTransactionController forexTransactionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testForexTransactionWithoutToken() {
        // Given
        LoginRequest loginRequest = new LoginRequest("user@example.com", "password");
        when(userRepository.findByEmail(anyString())).thenReturn(new User());

        // When
        driver.findElement(By.id("loginEmail")).sendKeys(loginRequest.getEmail());
        driver.findElement(By.id("loginPassword")).sendKeys(loginRequest.getPassword());
        driver.findElement(By.id("loginButton")).click();

        // Attempt to send forex transaction request without token
        ResponseEntity<String> response = forexTransactionController.sendForexTransaction(new AmountRequest(100));

        // Then
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertTrue(response.getBody().contains("Missing OAuth 2.0 token"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}