/**
 * Test Case ID: TC_Forex_002
 * Generated from Jira Ticket: BANK-3152
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:08:33
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ForexTransactionTest {

    private WebDriver driver;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountService accountService;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private ForexController forexController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testForexTransactionInsufficientFunds() {
        // Given
        String userId = "12345";
        when(userRepository.findById(userId)).thenReturn(Optional.of(new User(userId, 1000, "JPY")));
        when(accountService.initiateForexTransaction("JPY", "INR", 2000)).thenReturn(new ResponseEntity<>("Insufficient funds", HttpStatus.BAD_REQUEST));

        // When
        driver.findElement(By.id("transactionType")).sendKeys("Forex");
        driver.findElement(By.id("fromCurrency")).sendKeys("JPY");
        driver.findElement(By.id("toCurrency")).sendKeys("INR");
        driver.findElement(By.id("amount")).sendKeys("2000");
        driver.findElement(By.id("submitTransaction")).click();

        // Then
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        assertEquals("Insufficient funds", errorMessage);

        // Verify user balance is unchanged
        User user = userRepository.findById(userId).orElse(null);
        assertEquals(1000, user.getBalance());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}