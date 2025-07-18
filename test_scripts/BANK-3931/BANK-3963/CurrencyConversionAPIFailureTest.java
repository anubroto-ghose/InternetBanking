/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3963
 * Epic: BANK-3931
 * Generated on: 2025-07-18 17:22:09
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyConversionAPIFailureTest {

    private WebDriver driver;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @Test
    public void testCurrencyConversionAPIFailure() throws Exception {
        // Simulate API failure
        when(accountService.convertCurrency("USD", "EUR", 100.0)).thenThrow(new RuntimeException("API Failure"));

        // Trigger currency conversion
        WebElement amountInput = driver.findElement(By.id("amountInput"));
        amountInput.sendKeys("100");
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Assert that an error message is displayed
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertEquals("Currency conversion service is temporarily unavailable. Please try again later.", errorMessage.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}