/**
 * Test Case ID: TC_Forex_002
 * Generated from Jira Ticket: BANK-3152
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:41:17
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
import org.springframework.http.MediaType;
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

    @Mock
    private AccountService accountService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TokenService tokenService;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testForexTransactionInsufficientFunds() throws Exception {
        // Mocking user with insufficient funds
        User user = new User("testUser", 1000); // 1000 JPY
        when(userRepository.findById(any())).thenReturn(java.util.Optional.of(user));
        when(accountService.initiateForexTransaction(any(AmountRequest.class))).thenReturn("Insufficient funds");

        // Sending request to initiate forex transaction
        mockMvc.perform(MockMvcRequestBuilders.post("/api/forex/initiate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"fromCurrency\":\"JPY\",\"toCurrency\":\"INR\",\"amount\":\"2000\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Insufficient funds"));

        // Verifying that the user's JPY amount remains unchanged
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/balance")
                .param("currency", "JPY"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount").value(1000));
    }
}