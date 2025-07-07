/**
 * Test Case ID: TC_Forex_002
 * Generated from Jira Ticket: BANK-3152
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:55:05
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ForexTransactionTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private AccountService accountService;

    @Mock
    private UserRepository userRepository;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testForexTransactionInsufficientFunds() throws Exception {
        // Mock user and insufficient funds scenario
        User user = new User();
        user.setId(1L);
        user.setBalanceInJPY(1000);
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        // Navigate to the forex transaction page
        driver.get("http://localhost:8080/forex");

        // Fill in the transaction form
        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("5000"); // Trying to convert more than available

        WebElement fromCurrency = driver.findElement(By.id("fromCurrency"));
        fromCurrency.sendKeys("JPY");

        WebElement toCurrency = driver.findElement(By.id("toCurrency"));
        toCurrency.sendKeys("INR");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verify the response
        mockMvc.perform(MockMvcRequestBuilders.post("/api/forex/transaction")
                .contentType("application/json")
                .content("{\"amount\": 5000, \"fromCurrency\": \"JPY\", \"toCurrency\": \"INR\"}")
        )
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Insufficient funds"));

        // Assert that the balance has not changed
        assertEquals(1000, user.getBalanceInJPY());
    }
}