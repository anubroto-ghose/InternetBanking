/**
 * Test Case ID: TC_Conversion_004
 * Generated from Jira Ticket: BANK-2960
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:37:13
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
import org.springframework.test.context.ActiveProfiles;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CurrencyConversionTest {

    @Mock
    private AccountService accountService;

    @Mock
    private TokenService tokenService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CurrencyConversionController currencyConversionController;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/currency-conversion");
    }

    @Test
    public void testEdgeCaseINRAmount() {
        // Mocking the services
        when(accountService.convertCurrency(1000000000.0, "INR", "USD")).thenReturn(12000000.0);

        // Input an edge case amount in INR
        WebElement amountInput = driver.findElement(By.id("amountInput"));
        amountInput.sendKeys("1000000000"); // Edge case amount

        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Verify the conversion result
        WebElement resultElement = driver.findElement(By.id("conversionResult"));
        String resultText = resultElement.getText();

        // Assert the expected result
        assertEquals("Converted Amount: 12000000.0 USD", resultText);
    }

    // Clean up after tests
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}