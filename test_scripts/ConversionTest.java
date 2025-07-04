/**
 * Test Case ID: TC_Conversion_005
 * Generated from Jira Ticket: BANK-2961
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:51:34
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ConversionTest {

    private WebDriver driver;

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
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testDecimalHandlingInConversion() {
        // Mock the service response
        when(accountService.convertToUSD(any(Double.class))).thenReturn(0.0125);

        // Step 1: Input a decimal amount in INR
        WebElement amountInput = driver.findElement(By.id("amountInput"));
        amountInput.sendKeys("100.50");

        // Step 2: Click the convert button
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Step 3: Check the converted value for correct decimal handling
        WebElement resultElement = driver.findElement(By.id("result"));
        String resultText = resultElement.getText();

        // Assert the expected result
        assertEquals("Converted Amount: 0.0125 USD", resultText);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}