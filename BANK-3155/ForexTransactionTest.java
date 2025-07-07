/**
 * Test Case ID: TC_Forex_005
 * Generated from Jira Ticket: BANK-3155
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:07:34
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
    public void setup() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testSuccessfulForexTransaction() throws Exception {
        // Mock user data
        User user = new User();
        user.setId(1L);
        user.setCurrencyAmount(10000.0); // JPY

        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        // Initiate Forex transaction
        AmountRequest amountRequest = new AmountRequest();
        amountRequest.setAmount(10000.0);
        amountRequest.setFromCurrency("JPY");
        amountRequest.setToCurrency("INR");

        // Perform API call
        mockMvc.perform(MockMvcRequestBuilders.post("/api/forex/transaction")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(amountRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Transaction initiated successfully"));

        // Validate JPY amount deduction and INR credit
        assertEquals(0.0, user.getCurrencyAmount()); // JPY amount should be deducted
        // Assuming 10000 JPY = 6500 INR for this transaction
        assertEquals(6500.0, accountService.getUserBalanceInINR(user.getId()));
    }
}