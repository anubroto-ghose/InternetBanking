/**
 * Test Case ID: TC_Conversion_001
 * Generated from Jira Ticket: BANK-2957
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:37:59
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyConversionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/currency-conversion");
    }

    @Test
    public void testCurrencyConversion() throws Exception {
        // Mock the service response
        when(accountService.convertCurrency(any(Double.class), any(String.class))).thenReturn(13.5);

        // Input amount in INR
        WebElement amountInput = driver.findElement(By.id("amountInINR"));
        amountInput.sendKeys("100");

        // Click on convert button
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Wait for the result to be displayed
        Thread.sleep(2000); // Consider using WebDriverWait in production

        // Verify the displayed converted value
        WebElement resultElement = driver.findElement(By.id("resultUSD"));
        String resultText = resultElement.getText();
        assert resultText.equals("Converted Amount: $13.50");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}