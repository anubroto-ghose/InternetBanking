/**
 * Test Case ID: TC_Forex_004
 * Generated from Jira Ticket: BANK-3154
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:07:57
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestBody;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ForexTransactionTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AccountService accountService;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testInitiateForexTransactionWithNonExistentCustomer() throws Exception {
        // Mocking the user repository to return null for non-existent customer
        when(userRepository.findById(any())).thenReturn(null);

        // Starting the web application
        driver.get("http://localhost:8080/forex/initiate");

        // Sending request to initiate forex transaction
        WebElement customerIdField = driver.findElement(By.id("customerId"));
        customerIdField.sendKeys("nonExistentCustomerId");

        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("1000");

        WebElement submitButton = driver.findElement(By.id("submitTransaction"));
        submitButton.click();

        // Verifying the response
        mockMvc.perform(post("/api/forex/initiate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customerId\":\"nonExistentCustomerId\", \"amount\":1000}"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Customer not found"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}