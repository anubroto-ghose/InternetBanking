/**
 * Test Case ID: TC_Forex_001
 * Generated from Jira Ticket: BANK-3151
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:55:20
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ForexTransactionTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;
    
    @MockBean
    private TokenService tokenService;
    
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private ForexTransactionService forexTransactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testInitiateForexTransaction() throws InterruptedException {
        // Mocking the service responses
        when(accountService.initiateForexTransaction(any(AmountRequest.class))).thenReturn(ResponseEntity.ok(new ForexResponse("Transaction Successful", 1000, 130.0)));
        when(userRepository.findById(any())).thenReturn(Optional.of(new User("testuser", 10000.0)));

        // Initiate forex transaction
        driver.findElement(By.id("initiateForexButton")).click();
        Thread.sleep(2000); // Simulate wait for response

        // Assertions
        String responseMessage = driver.findElement(By.id("responseMessage")).getText();
        assertEquals("Transaction Successful", responseMessage);
        double updatedINR = userRepository.findById("testuser").get().getBalance();
        assertEquals(9000.0, updatedINR);
        double creditedJPY = forexTransactionService.getCreditedAmount();
        assertEquals(130.0, creditedJPY);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}